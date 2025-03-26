package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Closing;
import io.renren.modules.sys.service.ApplyService;
import io.renren.modules.sys.service.ClosingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/closing")
public class ClosingController extends AbstractController {
    @Autowired
    private ClosingService closingService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = closingService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){

        Closing closing = closingService.getById(id);
        return R.ok().put("closing", closing);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Closing closing){
        closing.setRanking(closing.getRanking());
        closing.setTotalMoney(closing.getTotalMoney());
        closingService.saveOrUpdate(closing);
        return R.ok();
    }


    @RequestMapping("/update")
    public R update(@RequestBody Closing closing){
        closingService.updateById(closing);
        closing.setTotalMoney(closing.getTotalMoney());
        closingService.saveOrUpdate(closing);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        closingService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}