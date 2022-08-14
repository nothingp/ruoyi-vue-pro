package cn.iocoder.yudao.module.lowcode.controller.admin.project.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@ApiModel(value = "管理后台 - 商城项目配置 Excel 导出 Request VO", description = "参数和 ProjectPageReqVO 是一致的")
@Data
public class ProjectExportReqVO {

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

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private Date[] createTime;

}
