package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.ApplyDao;
import io.renren.modules.sys.dao.ExpenditureDao;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Expenditure;
import io.renren.modules.sys.service.ApplyService;
import io.renren.modules.sys.service.ExpenditureService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("expenditureService")
public class ExpenditureServiceImpl extends ServiceImpl<ExpenditureDao, Expenditure> implements ExpenditureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        IPage<Expenditure> page = this.page(
            new Query<Expenditure>().getPage(params),
            new QueryWrapper<Expenditure>()
                .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

}
