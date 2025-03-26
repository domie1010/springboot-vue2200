package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.ApplyDao;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.service.ApplyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("applyService")
public class ApplyServiceImpl extends ServiceImpl<ApplyDao, Apply> implements ApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        String auditStu = (String)params.get("auditStu");
        IPage<Apply> page = this.page(
            new Query<Apply>().getPage(params),
            new QueryWrapper<Apply>()
                .like(StringUtils.isNotBlank(name),"name", name)
                    .eq(StringUtils.isNotBlank(auditStu),"audit_stu", auditStu)
        );

        return new PageUtils(page);
    }
    @Override
    public void auditById(String auditStu,Integer id) {
        baseMapper.auditById(auditStu,id);
    }

}
