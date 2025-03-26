package io.renren.modules.sys.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.Doorplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DoorplateDao extends BaseMapper<Doorplate> {
    void auditById(@Param("auditStu") String auditStu, @Param("id") Long id);
}