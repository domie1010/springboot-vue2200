package io.renren.modules.sys.controller;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.SysDictEntity;
import io.renren.modules.sys.service.SysDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("sys/dict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    @RequestMapping("/list")
    @RequiresPermissions("sys:dict:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysDictService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:dict:info")
    public R info(@PathVariable("id") Long id) {
        SysDictEntity dict = sysDictService.getById(id);
        return R.ok().put("dict", dict);
    }

    @RequestMapping("/save")
    public R save(@RequestBody SysDictEntity dict) {
        sysDictService.save(dict);
        return R.ok();
    }

    @RequestMapping("/test")
    public R test2() {
        List<SysDictEntity> list = sysDictService.list();
        return R.ok().put("mapList", list);
    }

    @RequestMapping("/cshi")
    public R cshi(@RequestParam("name") String name) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 12);
        map.put("name", "xxx街道");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 12);
        map2.put("name", "xxx街道2");
        list.add(map);
        list.add(map2);
        return R.ok().put("list", list);
    }

    @RequestMapping("/update")
    @RequiresPermissions("sys:dict:update")
    public R update(@RequestBody SysDictEntity dict) {
        //校验类型
        ValidatorUtils.validateEntity(dict);
        sysDictService.updateById(dict);
        return R.ok();
    }

    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sysDictService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}