package cn.iocoder.yudao.module.lowcode.controller.admin.project.vo;

import lombok.*;
import java.util.*;
import io.swagger.annotations.*;

@ApiModel("管理后台 - 商城项目配置 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProjectRespVO extends ProjectBaseVO {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
