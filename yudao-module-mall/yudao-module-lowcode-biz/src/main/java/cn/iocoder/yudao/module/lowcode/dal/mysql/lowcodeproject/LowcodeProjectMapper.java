package cn.iocoder.yudao.module.lowcode.dal.mysql.lowcodeproject;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;

/**
 * 商城项目配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface LowcodeProjectMapper extends BaseMapperX<LowcodeProjectDO> {

    default PageResult<LowcodeProjectDO> selectPage(LowcodeProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<LowcodeProjectDO>()
                .eqIfPresent(LowcodeProjectDO::getUserId, reqVO.getUserId())
                .likeIfPresent(LowcodeProjectDO::getName, reqVO.getName())
                .eqIfPresent(LowcodeProjectDO::getType, reqVO.getType())
                .eqIfPresent(LowcodeProjectDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(LowcodeProjectDO::getConfig, reqVO.getConfig())
                .eqIfPresent(LowcodeProjectDO::getLogo, reqVO.getLogo())
                .eqIfPresent(LowcodeProjectDO::getCover, reqVO.getCover())
                .eqIfPresent(LowcodeProjectDO::getPages, reqVO.getPages())
                .orderByDesc(LowcodeProjectDO::getId));
    }

    default List<LowcodeProjectDO> selectList(LowcodeProjectExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<LowcodeProjectDO>()
                .eqIfPresent(LowcodeProjectDO::getUserId, reqVO.getUserId())
                .likeIfPresent(LowcodeProjectDO::getName, reqVO.getName())
                .eqIfPresent(LowcodeProjectDO::getType, reqVO.getType())
                .eqIfPresent(LowcodeProjectDO::getIndustry, reqVO.getIndustry())
                .eqIfPresent(LowcodeProjectDO::getConfig, reqVO.getConfig())
                .eqIfPresent(LowcodeProjectDO::getLogo, reqVO.getLogo())
                .eqIfPresent(LowcodeProjectDO::getCover, reqVO.getCover())
                .eqIfPresent(LowcodeProjectDO::getPages, reqVO.getPages())
                .orderByDesc(LowcodeProjectDO::getId));
    }

}
