package cn.iocoder.yudao.module.lowcode.convert.project;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;

/**
 * 商城项目配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ProjectConvert {

    ProjectConvert INSTANCE = Mappers.getMapper(ProjectConvert.class);

    ProjectDO convert(ProjectCreateReqVO bean);

    ProjectDO convert(ProjectUpdateReqVO bean);

    ProjectRespVO convert(ProjectDO bean);

    List<ProjectRespVO> convertList(List<ProjectDO> list);

    PageResult<ProjectRespVO> convertPage(PageResult<ProjectDO> page);

    List<ProjectExcelVO> convertList02(List<ProjectDO> list);

}
