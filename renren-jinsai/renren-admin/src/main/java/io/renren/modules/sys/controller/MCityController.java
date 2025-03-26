///**
// * .
// *
// *
// *
// *
// */
//
//package io.renren.modules.sys.controller;
//
//import io.renren.common.utils.PageUtils;
//import io.renren.common.utils.R;
//import io.renren.common.validator.ValidatorUtils;
//import io.renren.modules.sys.entity.MCity;
//import io.renren.modules.sys.entity.SysDictEntity;
//import io.renren.modules.sys.service.MCityService;
//import io.renren.modules.sys.service.SysDictService;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.Map;
//
///**
// * 数据字典
// *
// * @author Mark sunlightcs@gmail.com
// */
//@RestController
//@RequestMapping("sys/city")
//public class MCityController {
//    @Autowired
//    private SysDictService sysDictService;
//    @Autowired
//    private MCityService cityService;
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
////    @RequiresPermissions("sys:city:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = cityService.queryPage(params);
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("sys:city:info")
//    public R info(@PathVariable("id") Long id){
//        MCity dict = cityService.getById(id);
//
//        return R.ok().put("city", dict);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
////    @RequiresPermissions("sys:city:save")
//    public R save(@RequestBody MCity city){
//        //校验类型
//        ValidatorUtils.validateEntity(city);
//
//        cityService.save(city);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("sys:city:update")
//    public R update(@RequestBody MCity city){
//        //校验类型
//        ValidatorUtils.validateEntity(city);
//
//        cityService.updateById(city);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("sys:city:delete")
//    public R delete(@RequestBody Long[] ids){
//        cityService.removeByIds(Arrays.asList(ids));
//
//        return R.ok();
//    }
//
//}
