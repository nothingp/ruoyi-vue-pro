package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.*;
import io.swagger.annotations.*;

/**
* 商城项目配置 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class LowcodeProjectBaseVO {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "项目类型")
    private String type;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "配置参数")
    private JSONObject config;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "页面配置")
    private JSONArray pages;

}
