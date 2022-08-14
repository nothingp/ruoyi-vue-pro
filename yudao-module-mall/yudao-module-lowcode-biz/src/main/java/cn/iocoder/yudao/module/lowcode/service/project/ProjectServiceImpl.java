package cn.iocoder.yudao.module.lowcode.service.project;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.lowcode.convert.project.ProjectConvert;
import cn.iocoder.yudao.module.lowcode.dal.mysql.project.ProjectMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.lowcode.enums.ErrorCodeConstants.*;

/**
 * 商城项目配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public String createProject(ProjectCreateReqVO createReqVO) {
        // 插入
        ProjectDO project = ProjectConvert.INSTANCE.convert(createReqVO);
        projectMapper.insert(project);
        // 返回
        return project.getId();
    }

    @Override
    public void updateProject(ProjectUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateProjectExists(updateReqVO.getId());
        // 更新
        ProjectDO updateObj = ProjectConvert.INSTANCE.convert(updateReqVO);
        projectMapper.updateById(updateObj);
    }

    @Override
    public void deleteProject(String id) {
        // 校验存在
        this.validateProjectExists(id);
        // 删除
        projectMapper.deleteById(id);
    }

    private void validateProjectExists(String id) {
        if (projectMapper.selectById(id) == null) {
            throw exception(PROJECT_NOT_EXISTS);
        }
    }

    @Override
    public ProjectDO getProject(String id) {
        return projectMapper.selectById(id);
    }

    @Override
    public List<ProjectDO> getProjectList(Collection<String> ids) {
        return projectMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ProjectDO> getProjectPage(ProjectPageReqVO pageReqVO) {
        return projectMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProjectDO> getProjectList(ProjectExportReqVO exportReqVO) {
        return projectMapper.selectList(exportReqVO);
    }

}
