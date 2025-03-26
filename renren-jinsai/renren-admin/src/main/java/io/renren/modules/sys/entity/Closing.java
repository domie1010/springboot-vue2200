package io.renren.modules.sys.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("js_closing")
public class Closing {
    @TableId
    private int id;
    private String jtType;
    private int bid;
    private String title;
    private Date startTime;
    private double totalMoney;
    private String ranking;
}