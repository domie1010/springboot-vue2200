package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Personal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalDao extends BaseMapper<Personal> {

}