package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.ApplyDao;
import io.renren.modules.sys.dao.TeamDao;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Team;
import io.renren.modules.sys.service.ApplyService;
import io.renren.modules.sys.service.TeamService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("teamService")
public class TeamServiceImpl extends ServiceImpl<TeamDao, Team> implements TeamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        IPage<Team> page = this.page(
            new Query<Team>().getPage(params),
            new QueryWrapper<Team>()
                .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

}
