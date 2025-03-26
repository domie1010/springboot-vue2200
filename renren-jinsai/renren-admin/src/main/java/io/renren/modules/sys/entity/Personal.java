package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2020/9/21.
 */
@Data
@TableName("js_personal")
public class Personal {
    @TableId
    private int id;
    private String title;
    private String name;
    private String college;
    private String className;
    private String grade;
    private String major;
    private String email;
    private String phone;
    ;


}

