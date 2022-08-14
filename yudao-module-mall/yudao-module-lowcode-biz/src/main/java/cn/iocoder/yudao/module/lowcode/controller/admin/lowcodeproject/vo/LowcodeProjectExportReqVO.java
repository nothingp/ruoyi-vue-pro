package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo;

import lombok.*;
import io.swagger.annotations.*;

@ApiModel(value = "管理后台 - 商城项目配置 Excel 导出 Request VO", description = "参数和 LowcodeProjectPageReqVO 是一致的")
@Data
public class LowcodeProjectExportReqVO {

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
