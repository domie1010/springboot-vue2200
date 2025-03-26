
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.City;

import java.util.Map;

public interface CityService extends IService<City> {

    PageUtils queryPage(Map<String, Object> params);
}

