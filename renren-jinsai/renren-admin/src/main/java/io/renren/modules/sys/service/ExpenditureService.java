
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Expenditure;

import java.util.Map;

public interface ExpenditureService extends IService<Expenditure> {

    PageUtils queryPage(Map<String, Object> params);
}

