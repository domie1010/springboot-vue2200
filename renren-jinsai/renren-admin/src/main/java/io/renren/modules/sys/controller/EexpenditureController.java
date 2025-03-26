package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Expenditure;
import io.renren.modules.sys.service.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/expenditure")
public class EexpenditureController extends AbstractController {
    @Autowired
    private ExpenditureService expenditureService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = expenditureService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Expenditure expenditure = expenditureService.getById(id);
        return R.ok().put("expenditure", expenditure);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Expenditure expenditure){
        expenditure.setTotal(expenditure.getZhuche()+expenditure.getRate()+expenditure.getTrain()+expenditure.getGuidance()
        +expenditure.getBonus()+expenditure.getOther()+expenditure.getHaocai());
        expenditureService.save(expenditure);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody Expenditure expenditure){
        expenditureService.updateById(expenditure);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        expenditureService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}