package cn.iocoder.yudao.module.lowcode.controller.app.lowcodeproject;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;
import cn.iocoder.yudao.module.lowcode.convert.lowcodeproject.LowcodeProjectConvert;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;
import cn.iocoder.yudao.module.lowcode.service.lowcodeproject.LowcodeProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;

@Api(tags = "前端 - 商城项目配置")
@RestController
@RequestMapping("/lowcode/project")
@Validated
public class AppLowcodeProjectController {

    @Resource
    private LowcodeProjectService lowcodeProjectService;

    @GetMapping("/get")
    @ApiOperation("获得商城项目配置")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = String.class)
    public CommonResult<LowcodeProjectRespVO> getLowcodeProject(@RequestParam("id") String id) {
        LowcodeProjectDO lowcodeProject = lowcodeProjectService.getLowcodeProject(id);
        return success(LowcodeProjectConvert.INSTANCE.convert(lowcodeProject));
    }
}
