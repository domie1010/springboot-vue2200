
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.City;

import java.util.Map;

public interface ApplyService extends IService<Apply> {

    PageUtils queryPage(Map<String, Object> params);

    void auditById(String auditStu,Integer id);
}

