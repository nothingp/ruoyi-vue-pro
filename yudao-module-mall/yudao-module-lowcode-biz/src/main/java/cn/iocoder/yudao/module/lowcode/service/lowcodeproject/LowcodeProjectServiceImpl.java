package cn.iocoder.yudao.module.lowcode.service.lowcodeproject;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.lowcode.convert.lowcodeproject.LowcodeProjectConvert;
import cn.iocoder.yudao.module.lowcode.dal.mysql.lowcodeproject.LowcodeProjectMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.lowcode.enums.ErrorCodeConstants.*;

/**
 * 商城项目配置 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class LowcodeProjectServiceImpl implements LowcodeProjectService {

    @Resource
    private LowcodeProjectMapper lowcodeProjectMapper;

    @Override
    public String createLowcodeProject(LowcodeProjectCreateReqVO createReqVO) {
        // 插入
        LowcodeProjectDO lowcodeProject = LowcodeProjectConvert.INSTANCE.convert(createReqVO);
        lowcodeProjectMapper.insert(lowcodeProject);
        // 返回
        return lowcodeProject.getId();
    }

    @Override
    public void updateLowcodeProject(LowcodeProjectUpdateReqVO updateReqVO) {
        // 校验存在
        this.validateLowcodeProjectExists(updateReqVO.getId());
        // 更新
        LowcodeProjectDO updateObj = LowcodeProjectConvert.INSTANCE.convert(updateReqVO);
        lowcodeProjectMapper.updateById(updateObj);
    }

    @Override
    public void deleteLowcodeProject(String id) {
        // 校验存在
        this.validateLowcodeProjectExists(id);
        // 删除
        lowcodeProjectMapper.deleteById(id);
    }

    private void validateLowcodeProjectExists(String id) {
        if (lowcodeProjectMapper.selectById(id) == null) {
            throw exception(LOWCODE_PROJECT_NOT_EXISTS);
        }
    }

    @Override
    public LowcodeProjectDO getLowcodeProject(String id) {
        return lowcodeProjectMapper.selectById(id);
    }

    @Override
    public List<LowcodeProjectDO> getLowcodeProjectList(Collection<String> ids) {
        return lowcodeProjectMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<LowcodeProjectDO> getLowcodeProjectPage(LowcodeProjectPageReqVO pageReqVO) {
        return lowcodeProjectMapper.selectPage(pageReqVO);
    }

    @Override
    public List<LowcodeProjectDO> getLowcodeProjectList(LowcodeProjectExportReqVO exportReqVO) {
        return lowcodeProjectMapper.selectList(exportReqVO);
    }

}
