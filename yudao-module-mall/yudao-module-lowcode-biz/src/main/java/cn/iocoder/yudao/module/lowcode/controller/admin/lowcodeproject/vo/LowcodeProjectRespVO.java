package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo;

import lombok.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商城项目配置 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LowcodeProjectRespVO extends LowcodeProjectBaseVO {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

}
