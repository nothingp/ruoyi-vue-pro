package cn.iocoder.yudao.module.lowcode.convert.lowcodeproject;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;

/**
 * 商城项目配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface LowcodeProjectConvert {

    LowcodeProjectConvert INSTANCE = Mappers.getMapper(LowcodeProjectConvert.class);

    LowcodeProjectDO convert(LowcodeProjectCreateReqVO bean);

    LowcodeProjectDO convert(LowcodeProjectUpdateReqVO bean);

    LowcodeProjectRespVO convert(LowcodeProjectDO bean);

    List<LowcodeProjectRespVO> convertList(List<LowcodeProjectDO> list);

    PageResult<LowcodeProjectRespVO> convertPage(PageResult<LowcodeProjectDO> page);

    List<LowcodeProjectExcelVO> convertList02(List<LowcodeProjectDO> list);

}
