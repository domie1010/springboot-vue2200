/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("m_city")
public class MCity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TableId
	private Integer id;
	private String name;
	private String pname;
	private String code;
	private String longitudeAndLatitude;
	private String filed;

}
