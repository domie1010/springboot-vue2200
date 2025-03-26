package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/apply")
public class ApplyController extends AbstractController {
    @Autowired
    private ApplyService applyService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = applyService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Apply apply = applyService.getById(id);
        return R.ok().put("apply", apply);
    }
    @RequestMapping("/save")
    public R save(@RequestBody Apply apply){
        apply.setAuditStu("未审核");
        applyService.save(apply);
        return R.ok();
    }
    @RequestMapping("/auditById")
    public R auditById(@RequestParam("id") Integer id,@RequestParam("auditStu") String auditStu){
        applyService.auditById(auditStu,id);
        return R.ok();
    }

    @RequestMapping("/auditList")//审核列表 显示所有未审核的
    public R auditList(Map<String, Object> params){
        params.put("auditStu","未审核");
        PageUtils page = applyService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/update")
    public R update(@RequestBody Apply apply){
        applyService.updateById(apply);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        applyService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}