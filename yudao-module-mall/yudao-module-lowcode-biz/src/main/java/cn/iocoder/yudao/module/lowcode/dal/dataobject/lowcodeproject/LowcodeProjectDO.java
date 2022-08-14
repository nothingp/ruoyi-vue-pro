package cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商城项目配置 DO
 *
 * @author 芋道源码
 */
@TableName(value = "mall_lowcode_project",autoResultMap = true)
@KeySequence("mall_lowcode_project_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LowcodeProjectDO extends BaseDO {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目类型
     */
    private String type;
    /**
     * 行业
     */
    private String industry;
    /**
     * 配置参数
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONObject config;
    /**
     * logo
     */
    private String logo;
    /**
     * 封面
     */
    private String cover;
    /**
     * 页面配置
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONArray pages;

}
