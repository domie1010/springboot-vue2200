package io.renren.modules.sys.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("doorplate")
public class Doorplate {
    @TableId
    private Long id;
    private String areaName;
    private String cityName;
    private String housingName;
    private String ridgepoleNumber;
    private String applyUserName;
    private Date applyTime;
    private String auditStu;
}