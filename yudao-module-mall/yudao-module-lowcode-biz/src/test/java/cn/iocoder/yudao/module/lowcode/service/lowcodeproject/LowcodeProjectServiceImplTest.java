package cn.iocoder.yudao.module.lowcode.service.lowcodeproject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.lowcode.controller.admin.lowcodeproject.vo.*;
import cn.iocoder.yudao.module.lowcode.dal.dataobject.lowcodeproject.LowcodeProjectDO;
import cn.iocoder.yudao.module.lowcode.dal.mysql.lowcodeproject.LowcodeProjectMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.springframework.context.annotation.Import;
import java.util.*;

import static cn.iocoder.yudao.module.lowcode.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* {@link LowcodeProjectServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(LowcodeProjectServiceImpl.class)
public class LowcodeProjectServiceImplTest extends BaseDbUnitTest {

    @Resource
    private LowcodeProjectServiceImpl lowcodeProjectService;

    @Resource
    private LowcodeProjectMapper lowcodeProjectMapper;

    @Test
    public void testCreateLowcodeProject_success() {
        // 准备参数
        LowcodeProjectCreateReqVO reqVO = randomPojo(LowcodeProjectCreateReqVO.class);

        // 调用
        String lowcodeProjectId = lowcodeProjectService.createLowcodeProject(reqVO);
        // 断言
        assertNotNull(lowcodeProjectId);
        // 校验记录的属性是否正确
        LowcodeProjectDO lowcodeProject = lowcodeProjectMapper.selectById(lowcodeProjectId);
        assertPojoEquals(reqVO, lowcodeProject);
    }

    @Test
    public void testUpdateLowcodeProject_success() {
        // mock 数据
        LowcodeProjectDO dbLowcodeProject = randomPojo(LowcodeProjectDO.class);
        lowcodeProjectMapper.insert(dbLowcodeProject);// @Sql: 先插入出一条存在的数据
        // 准备参数
        LowcodeProjectUpdateReqVO reqVO = randomPojo(LowcodeProjectUpdateReqVO.class, o -> {
            o.setId(dbLowcodeProject.getId()); // 设置更新的 ID
        });

        // 调用
        lowcodeProjectService.updateLowcodeProject(reqVO);
        // 校验是否更新正确
        LowcodeProjectDO lowcodeProject = lowcodeProjectMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, lowcodeProject);
    }

    @Test
    public void testUpdateLowcodeProject_notExists() {
        // 准备参数
        LowcodeProjectUpdateReqVO reqVO = randomPojo(LowcodeProjectUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> lowcodeProjectService.updateLowcodeProject(reqVO), LOWCODE_PROJECT_NOT_EXISTS);
    }

    @Test
    public void testDeleteLowcodeProject_success() {
        // mock 数据
        LowcodeProjectDO dbLowcodeProject = randomPojo(LowcodeProjectDO.class);
        lowcodeProjectMapper.insert(dbLowcodeProject);// @Sql: 先插入出一条存在的数据
        // 准备参数
        String id = dbLowcodeProject.getId();

        // 调用
        lowcodeProjectService.deleteLowcodeProject(id);
       // 校验数据不存在了
       assertNull(lowcodeProjectMapper.selectById(id));
    }

    @Test
    public void testDeleteLowcodeProject_notExists() {
        // 准备参数
//        String id = randomStringId();
//
//        // 调用, 并断言异常
//        assertServiceException(() -> lowcodeProjectService.deleteLowcodeProject(id), LOWCODE_PROJECT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLowcodeProjectPage() {
       // mock 数据
       LowcodeProjectDO dbLowcodeProject = randomPojo(LowcodeProjectDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setName(null);
           o.setType(null);
           o.setIndustry(null);
           o.setConfig(null);
           o.setLogo(null);
           o.setCover(null);
           o.setPages(null);
       });
       lowcodeProjectMapper.insert(dbLowcodeProject);
       // 测试 userId 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setUserId(null)));
       // 测试 name 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setName(null)));
       // 测试 type 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setType(null)));
       // 测试 industry 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setIndustry(null)));
       // 测试 config 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setConfig(null)));
       // 测试 logo 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setLogo(null)));
       // 测试 cover 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setCover(null)));
       // 测试 pages 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setPages(null)));
       // 准备参数
       LowcodeProjectPageReqVO reqVO = new LowcodeProjectPageReqVO();
       reqVO.setUserId(null);
       reqVO.setName(null);
       reqVO.setType(null);
       reqVO.setIndustry(null);
       reqVO.setConfig(null);
       reqVO.setLogo(null);
       reqVO.setCover(null);
       reqVO.setPages(null);

       // 调用
       PageResult<LowcodeProjectDO> pageResult = lowcodeProjectService.getLowcodeProjectPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbLowcodeProject, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetLowcodeProjectList() {
       // mock 数据
       LowcodeProjectDO dbLowcodeProject = randomPojo(LowcodeProjectDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setName(null);
           o.setType(null);
           o.setIndustry(null);
           o.setConfig(null);
           o.setLogo(null);
           o.setCover(null);
           o.setPages(null);
       });
       lowcodeProjectMapper.insert(dbLowcodeProject);
       // 测试 userId 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setUserId(null)));
       // 测试 name 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setName(null)));
       // 测试 type 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setType(null)));
       // 测试 industry 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setIndustry(null)));
       // 测试 config 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setConfig(null)));
       // 测试 logo 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setLogo(null)));
       // 测试 cover 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setCover(null)));
       // 测试 pages 不匹配
       lowcodeProjectMapper.insert(cloneIgnoreId(dbLowcodeProject, o -> o.setPages(null)));
       // 准备参数
       LowcodeProjectExportReqVO reqVO = new LowcodeProjectExportReqVO();
       reqVO.setUserId(null);
       reqVO.setName(null);
       reqVO.setType(null);
       reqVO.setIndustry(null);
       reqVO.setConfig(null);
       reqVO.setLogo(null);
       reqVO.setCover(null);
       reqVO.setPages(null);

       // 调用
       List<LowcodeProjectDO> list = lowcodeProjectService.getLowcodeProjectList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbLowcodeProject, list.get(0));
    }

}
