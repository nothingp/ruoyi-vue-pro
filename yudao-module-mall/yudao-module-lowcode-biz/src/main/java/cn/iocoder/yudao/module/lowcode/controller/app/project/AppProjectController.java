package cn.iocoder.yudao.module.lowcode.controller.app.project;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.ProjectRespVO;
import cn.iocoder.yudao.module.lowcode.convert.project.ProjectConvert;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.module.lowcode.service.project.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "前端 - 商城项目配置")
@RestController
@RequestMapping("/lowcode/project")
@Validated
public class AppProjectController {

    @Resource
    private ProjectService projectService;


    @GetMapping("/get")
    @ApiOperation("获得商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    public CommonResult<ProjectRespVO> getProject(@RequestParam("id") String id) {
        ProjectDO project = projectService.getProject(id);
        return success(ProjectConvert.INSTANCE.convert(project));
    }
}
