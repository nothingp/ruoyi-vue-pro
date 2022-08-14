package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo;

import lombok.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@ApiModel("管理后台 - 商城项目配置分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LowcodeProjectPageReqVO extends PageParam {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "项目类型")
    private String type;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "配置参数")
    private String config;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "页面配置")
    private String pages;

}
