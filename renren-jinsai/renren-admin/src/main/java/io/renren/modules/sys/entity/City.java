package io.renren.modules.sys.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("city")
public class City {
    @TableId
    private Long id;
    private String name;
    private String pname;
    private String code;
    private String longitudeAndLatitude;
    private String remark;
}