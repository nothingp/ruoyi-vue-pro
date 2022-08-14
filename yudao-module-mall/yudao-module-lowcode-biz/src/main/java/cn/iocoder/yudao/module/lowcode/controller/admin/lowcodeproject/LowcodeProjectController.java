package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.*;

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

import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;
import cn.iocoder.yudao.module.lowcode.convert.lowcodeproject.LowcodeProjectConvert;
import cn.iocoder.yudao.module.lowcode.service.lowcodeproject.LowcodeProjectService;

@Api(tags = "管理后台 - 商城项目配置")
@RestController
@RequestMapping("/lowcode/project")
@Validated
public class LowcodeProjectController {

    @Resource
    private LowcodeProjectService lowcodeProjectService;

    @PostMapping("/create")
    @ApiOperation("创建商城项目配置")
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:create')")
    public CommonResult<String> createLowcodeProject(@Valid @RequestBody LowcodeProjectCreateReqVO createReqVO) {
        return success(lowcodeProjectService.createLowcodeProject(createReqVO));
    }

    @PutMapping("/update")
    @ApiOperation("更新商城项目配置")
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:update')")
    public CommonResult<Boolean> updateLowcodeProject(@Valid @RequestBody LowcodeProjectUpdateReqVO updateReqVO) {
        lowcodeProjectService.updateLowcodeProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:delete')")
    public CommonResult<Boolean> deleteLowcodeProject(@RequestParam("id") String id) {
        lowcodeProjectService.deleteLowcodeProject(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获得商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:query')")
    public CommonResult<LowcodeProjectRespVO> getLowcodeProject(@RequestParam("id") String id) {
        LowcodeProjectDO lowcodeProject = lowcodeProjectService.getLowcodeProject(id);
        return success(LowcodeProjectConvert.INSTANCE.convert(lowcodeProject));
    }

    @GetMapping("/list")
    @ApiOperation("获得商城项目配置列表")
    @ApiImplicitParam(name = "ids", value = "编号列表", required = true, example = "1024", dataTypeClass = List.class)
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:query')")
    public CommonResult<List<LowcodeProjectRespVO>> getLowcodeProjectList(@RequestParam("ids") Collection<String> ids) {
        List<LowcodeProjectDO> list = lowcodeProjectService.getLowcodeProjectList(ids);
        return success(LowcodeProjectConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @ApiOperation("获得商城项目配置分页")
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:query')")
    public CommonResult<PageResult<LowcodeProjectRespVO>> getLowcodeProjectPage(@Valid LowcodeProjectPageReqVO pageVO) {
        PageResult<LowcodeProjectDO> pageResult = lowcodeProjectService.getLowcodeProjectPage(pageVO);
        return success(LowcodeProjectConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @ApiOperation("导出商城项目配置 Excel")
    @PreAuthorize("@ss.hasPermission('mall:lowcode-project:export')")
    @OperateLog(type = EXPORT)
    public void exportLowcodeProjectExcel(@Valid LowcodeProjectExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<LowcodeProjectDO> list = lowcodeProjectService.getLowcodeProjectList(exportReqVO);
        // 导出 Excel
        List<LowcodeProjectExcelVO> datas = LowcodeProjectConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "商城项目配置.xls", "数据", LowcodeProjectExcelVO.class, datas);
    }

}
