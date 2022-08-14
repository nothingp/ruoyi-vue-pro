package cn.iocoder.yudao.module.lowcode.service.project;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.lowcode.controller.admin.project.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.project.ProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 商城项目配置 Service 接口
 *
 * @author 芋道源码
 */
public interface ProjectService {

    /**
     * 创建商城项目配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    String createProject(@Valid ProjectCreateReqVO createReqVO);

    /**
     * 更新商城项目配置
     *
     * @param updateReqVO 更新信息
     */
    void updateProject(@Valid ProjectUpdateReqVO updateReqVO);

    /**
     * 删除商城项目配置
     *
     * @param id 编号
     */
    void deleteProject(String id);

    /**
     * 获得商城项目配置
     *
     * @param id 编号
     * @return 商城项目配置
     */
    ProjectDO getProject(String id);

    /**
     * 获得商城项目配置列表
     *
     * @param ids 编号
     * @return 商城项目配置列表
     */
    List<ProjectDO> getProjectList(Collection<String> ids);

    /**
     * 获得商城项目配置分页
     *
     * @param pageReqVO 分页查询
     * @return 商城项目配置分页
     */
    PageResult<ProjectDO> getProjectPage(ProjectPageReqVO pageReqVO);

    /**
     * 获得商城项目配置列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 商城项目配置列表
     */
    List<ProjectDO> getProjectList(ProjectExportReqVO exportReqVO);

}
