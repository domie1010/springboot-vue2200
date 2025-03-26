package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Closing;
import io.renren.modules.sys.entity.Team;
import io.renren.modules.sys.service.ClosingService;
import io.renren.modules.sys.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sys/team")
public class TeamController extends AbstractController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private ClosingService closingService;

    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = teamService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Team team = teamService.getById(id);
        return R.ok().put("team", team);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Team team){
        team.setBmTime(new Date());
        teamService.save(team);
        Closing closing=new Closing();
        closing.setBid(team.getId());
        closing.setJtType("团队赛");
        closing.setStartTime(new Date());
        closing.setTitle(team.getTitle());
        closingService.save(closing);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody Team team){
        teamService.updateById(team);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        teamService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}