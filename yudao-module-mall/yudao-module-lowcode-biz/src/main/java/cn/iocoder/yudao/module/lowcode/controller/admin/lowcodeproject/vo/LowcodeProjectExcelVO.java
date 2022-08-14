package cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 商城项目配置 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class LowcodeProjectExcelVO {

    @ExcelProperty("主键")
    private String id;

    @ExcelProperty("用户id")
    private Long userId;

    @ExcelProperty("项目名称")
    private String name;

    @ExcelProperty("项目类型")
    private String type;

    @ExcelProperty("行业")
    private String industry;

    @ExcelProperty("配置参数")
    private JSONObject config;

    @ExcelProperty("logo")
    private String logo;

    @ExcelProperty("封面")
    private String cover;

    @ExcelProperty("页面配置")
    private JSONArray pages;

}
