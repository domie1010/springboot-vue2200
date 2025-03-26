package io.renren.modules.sys.service;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.Doorplate;
import java.util.Map;
public interface DoorplateService extends IService<Doorplate> {
    PageUtils queryPage(Map<String, Object> params);
    void auditById(String auditStu,Long id);
}