package io.renren.modules.sys.controller;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.Doorplate;
import io.renren.modules.sys.service.DoorplateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
@RestController
@RequestMapping("/sys/doorplate")
public class DoorplateController extends AbstractController {
    @Autowired
    private DoorplateService doorplateService;
    @RequestMapping("/list")
    public R list(Map<String, Object> params){
        PageUtils page = doorplateService.queryPage(params);
        return R.ok().put("page", page);
    }
    @RequestMapping("/auditList")//审核列表 显示所有未审核的
    public R auditList(Map<String, Object> params){
        params.put("auditStu","未审核");
        PageUtils page = doorplateService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/auditById")
    public R auditById(@RequestParam("id") Long id,@RequestParam("auditStu") String auditStu){
        doorplateService.auditById(auditStu,id);
        return R.ok();
    }
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        Doorplate doorplate = doorplateService.getById(id);
        return R.ok().put("doorplate", doorplate);
    }
    @RequestMapping("/save")
    @RequiresPermissions("sys:menpai:save")
    public R save(@RequestBody Doorplate doorplate){
        String  username =this.getUser().getUsername();
        doorplate.setApplyUserName(username);
        doorplate.setAuditStu("未审核");
        doorplate.setApplyTime(new Date());
        doorplateService.save(doorplate);
        return R.ok();
    }
    @RequestMapping("/update")
    public R update(@RequestBody Doorplate doorplate){
        doorplateService.updateById(doorplate);
        return R.ok();
    }
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        doorplateService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}