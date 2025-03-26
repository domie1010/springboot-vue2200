package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.City;
import io.renren.modules.sys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/sys/city")
public class CityController extends AbstractController {
    @Autowired
    private CityService cityService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = cityService.queryPage(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/test")
    public R test2(){
        List<City> list = cityService.list();
        return R.ok().put("mapList",list);
    }
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        City city = cityService.getById(id);
        return R.ok().put("city", city);
    }
    @RequestMapping("/save")
    public R save(@RequestBody City dept){
        cityService.save(dept);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody City dept){
        cityService.updateById(dept);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cityService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}