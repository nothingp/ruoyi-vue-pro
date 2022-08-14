package cn.iocoder.yudao.module.lowcode.controller.admin.project;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.module.lowcode.convert.project.ProjectConvert;
import cn.iocoder.yudao.module.lowcode.service.project.ProjectService;

@Api(tags = "管理后台 - 商城项目配置")
@RestController
@RequestMapping("/lowcode/project")
@Validated
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @PostMapping("/create")
    @ApiOperation("创建商城项目配置")
    @PreAuthorize("@ss.hasPermission('lowcode:project:create')")
    public CommonResult<String> createProject(@Valid @RequestBody ProjectCreateReqVO createReqVO) {
        return success(projectService.createProject(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商城项目配置")
    @PreAuthorize("@ss.hasPermission('lowcode:project:update')")
    public CommonResult<Boolean> updateProject(@Valid @RequestBody ProjectUpdateReqVO updateReqVO) {
        projectService.updateProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('lowcode:project:delete')")
    public CommonResult<Boolean> deleteProject(@RequestParam("id") String id) {
        projectService.deleteProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('lowcode:project:query')")
    public CommonResult<ProjectRespVO> getProject(@RequestParam("id") String id) {
        ProjectDO project = projectService.getProject(id);
        return success(ProjectConvert.INSTANCE.convert(project));
    }

    @GetMapping("/list")
    @ApiOperation("获得商城项目配置列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024,2048", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('lowcode:project:query')")
    public CommonResult<List<ProjectRespVO>> getProjectList(@RequestParam("ids") Collection<String> ids) {
        List<ProjectDO> list = projectService.getProjectList(ids);
        return success(ProjectConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商城项目配置分页")
    @PreAuthorize("@ss.hasPermission('lowcode:project:query')")
    public CommonResult<PageResult<ProjectRespVO>> getProjectPage(@Valid ProjectPageReqVO pageVO) {
        PageResult<ProjectDO> pageResult = projectService.getProjectPage(pageVO);
        return success(ProjectConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商城项目配置 Excel")
    @PreAuthorize("@ss.hasPermission('lowcode:project:export')")
    @OperateLog(type = EXPORT)
    public void exportProjectExcel(@Valid ProjectExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ProjectDO> list = projectService.getProjectList(exportReqVO);
        // 导出 Excel
        List<ProjectExcelVO> datas = ProjectConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商城项目配置.xls", "数据", ProjectExcelVO.class, datas);
    }

}
