package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Closing;
import io.renren.modules.sys.entity.Personal;
import io.renren.modules.sys.service.ClosingService;
import io.renren.modules.sys.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sys/personal")
public class PersonalController extends AbstractController {
    @Autowired
    private PersonalService personalService;
    @Autowired
    private ClosingService closingService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = personalService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Personal personal = personalService.getById(id);
        return R.ok().put("personal", personal);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Personal personal){
        personalService.save(personal);
        Closing closing=new Closing();
        closing.setBid(personal.getId());
        closing.setJtType("个人赛");
        closing.setStartTime(new Date());
        closing.setTitle(personal.getTitle());
        closingService.save(closing);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody Personal personal){
        personalService.updateById(personal);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        personalService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}