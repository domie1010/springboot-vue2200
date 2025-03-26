package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2020/9/21.
 */
@Data
@TableName("js_team")
public class Team {
    @TableId
    private int id;
    private String num;
    private String title;
    private Date bmTime;
}

