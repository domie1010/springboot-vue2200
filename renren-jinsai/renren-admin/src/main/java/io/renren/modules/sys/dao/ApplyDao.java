package io.renren.modules.sys.dao;
        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import io.renren.modules.sys.entity.Apply;
        import io.renren.modules.sys.entity.Doorplate;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplyDao extends BaseMapper<Apply> {
        void auditById(@Param("auditStu") String auditStu, @Param("id") int id);
}