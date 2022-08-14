package cn.iocoder.yudao.module.lowcode.dal.mysql.project;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.*;

/**
 * 商城项目配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProjectMapper extends BaseMapperX<ProjectDO> {

    default PageResult<ProjectDO> selectPage(ProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProjectDO>()
                .eqIfPresent(ProjectDO::getUserId, reqVO.getUserId())
                .likeIfPresent(ProjectDO::getName, reqVO.getName())
                .eqIfPresent(ProjectDO::getType, reqVO.getType())
                .eqIfPresent(ProjectDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(ProjectDO::getConfig, reqVO.getConfig())
                .eqIfPresent(ProjectDO::getLogo, reqVO.getLogo())
                .eqIfPresent(ProjectDO::getCover, reqVO.getCover())
                .eqIfPresent(ProjectDO::getPages, reqVO.getPages())
                .betweenIfPresent(ProjectDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProjectDO::getId));
    }

    default List<ProjectDO> selectList(ProjectExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ProjectDO>()
                .eqIfPresent(ProjectDO::getUserId, reqVO.getUserId())
                .likeIfPresent(ProjectDO::getName, reqVO.getName())
                .eqIfPresent(ProjectDO::getType, reqVO.getType())
                .eqIfPresent(ProjectDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(ProjectDO::getConfig, reqVO.getConfig())
                .eqIfPresent(ProjectDO::getLogo, reqVO.getLogo())
                .eqIfPresent(ProjectDO::getCover, reqVO.getCover())
                .eqIfPresent(ProjectDO::getPages, reqVO.getPages())
                .betweenIfPresent(ProjectDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProjectDO::getId));
    }

}
