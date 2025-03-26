package io.renren.modules.sys.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("inform")
public class Inform {
    @TableId
    private long id;
    private String title;
    private String content;
    private Date createTime;
    private String type;
}