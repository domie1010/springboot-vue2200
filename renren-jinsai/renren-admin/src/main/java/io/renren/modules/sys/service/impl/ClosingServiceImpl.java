package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.ClosingDao;
import io.renren.modules.sys.dao.ClosingDao;
import io.renren.modules.sys.entity.Closing;
import io.renren.modules.sys.entity.Closing;
import io.renren.modules.sys.service.ClosingService;
import io.renren.modules.sys.service.ClosingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("closingService")
public class ClosingServiceImpl extends ServiceImpl<ClosingDao, Closing> implements ClosingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");
        IPage<Closing> page = this.page(
            new Query<Closing>().getPage(params),
            new QueryWrapper<Closing>()
                .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }
}
