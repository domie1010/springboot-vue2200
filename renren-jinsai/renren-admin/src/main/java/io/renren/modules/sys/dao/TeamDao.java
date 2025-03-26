package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.Apply;
import io.renren.modules.sys.entity.Team;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamDao extends BaseMapper<Team> {

}