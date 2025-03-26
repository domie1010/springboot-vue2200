package io.renren.modules.sys.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.DoorplateDao;
import io.renren.modules.sys.entity.Doorplate;
import io.renren.modules.sys.service.DoorplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("doorplateService")
public class DoorplateServiceImpl extends ServiceImpl<DoorplateDao, Doorplate> implements DoorplateService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        String auditStu = (String)params.get("auditStu");
        IPage<Doorplate> page = this.page(
                new Query<Doorplate>().getPage(params),
                new QueryWrapper<Doorplate>()
                        .like(StringUtils.isNotBlank(name),"name", name)
                        .eq(StringUtils.isNotBlank(auditStu),"audit_stu", auditStu)
        );
        return new PageUtils(page);
    }

    @Override
    public void auditById(String auditStu, Long id) {
        baseMapper.auditById(auditStu, id);
    }
}