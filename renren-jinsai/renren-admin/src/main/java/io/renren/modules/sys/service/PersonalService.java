
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.City;
import io.renren.modules.sys.entity.Personal;

import java.util.Map;

public interface PersonalService extends IService<Personal> {

    PageUtils queryPage(Map<String, Object> params);
}

