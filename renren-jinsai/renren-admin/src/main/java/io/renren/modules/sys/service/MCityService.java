/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MCity;

import java.util.Map;

/**
 *
 */
public interface MCityService extends IService<MCity> {

    PageUtils queryPage(Map<String, Object> params);
}

