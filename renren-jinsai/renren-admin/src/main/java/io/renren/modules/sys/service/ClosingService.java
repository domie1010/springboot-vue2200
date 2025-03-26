
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Closing;

import java.util.Map;

public interface ClosingService extends IService<Closing> {

    PageUtils queryPage(Map<String, Object> params);

}

