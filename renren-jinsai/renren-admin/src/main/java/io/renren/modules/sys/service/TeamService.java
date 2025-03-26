
package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Team;

import java.util.Map;

public interface TeamService extends IService<Team> {

    PageUtils queryPage(Map<String, Object> params);
}

