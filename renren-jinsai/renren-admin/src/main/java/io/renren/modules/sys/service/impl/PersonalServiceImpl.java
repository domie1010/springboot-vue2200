package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.ApplyDao;
import io.renren.modules.sys.dao.PersonalDao;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Personal;
import io.renren.modules.sys.service.ApplyService;
import io.renren.modules.sys.service.PersonalService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("personalService")
public class PersonalServiceImpl extends ServiceImpl<PersonalDao, Personal> implements PersonalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        IPage<Personal> page = this.page(
            new Query<Personal>().getPage(params),
            new QueryWrapper<Personal>()
                .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

}
