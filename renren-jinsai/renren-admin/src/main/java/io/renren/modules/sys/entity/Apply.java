package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2020/9/21.
 */
@Data
@TableName("js_apply")
public class Apply {
    @TableId
    private Long id;
    private String name;
    private String zsdw;
    private String type;
    private String principal;
    private String phone;
    private String email;
    private String startTime;
    private String entTime;
    private String majozhuban;
    private String sponsor;
    private String undertaeker;
    private String applyTime;
    private String remark;
    private String auditStu;

}

