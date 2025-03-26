package io.renren.modules.sys.controller;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Inform;
import io.renren.modules.sys.service.InformmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
@RestController
@RequestMapping("/sys/inform")
public class InformController extends AbstractController {
    @Autowired
    private InformmService informmService;
    @RequestMapping("/list")
    public R list(@RequestParam("type") String type, Map<String, Object> params){
        params.put("type",type);
        PageUtils page = informmService.queryPage(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Inform inform = informmService.getById(id);
        return R.ok().put("inform", inform);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Inform inform){
        inform.setCreateTime(new Date());
        informmService.save(inform);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody Inform inform){
        informmService.updateById(inform);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        informmService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}