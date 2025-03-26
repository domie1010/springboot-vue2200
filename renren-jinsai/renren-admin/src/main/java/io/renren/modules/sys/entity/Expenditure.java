package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Administrator on 2020/9/21.
 */
@Data
@TableName("js_expenditure")
public class Expenditure {
    @TableId
    private Long id;
    private String name;
    private double zhuche;
    private double rate;
    private double train;
    private double guidance;
    private double haocai;
    private double bonus;
    private double other;
    private double total;


}

