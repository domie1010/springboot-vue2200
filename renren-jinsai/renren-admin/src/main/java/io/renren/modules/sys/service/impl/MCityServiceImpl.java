/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.MCityDao;
import io.renren.modules.sys.entity.MCity;
import io.renren.modules.sys.service.MCityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mCityService")
public class MCityServiceImpl extends ServiceImpl<MCityDao, MCity> implements MCityService {
	

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String name = (String)params.get("name");
		IPage<MCity> page = this.page(
				new Query<MCity>().getPage(params),
				new QueryWrapper<MCity>()
						.like(StringUtils.isNotBlank(name),"name", name)
		);

		return new PageUtils(page);
	}
}
