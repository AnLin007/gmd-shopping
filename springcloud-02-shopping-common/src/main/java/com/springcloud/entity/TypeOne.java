package com.springcloud.entity;
/**
 * type_one表对应的实体类，用于保存表中一行一级类别信息
 * @author 陈安平
 *
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeOne implements java.io.Serializable {
	private static final long serialVersionUID = -2690542590151848525L;
	/**
	 * 类型一编号
	 */
    private Integer typeOneId;
    /**
	 * 类型一名称
	 */
    private String typeOneName;
    /**
	 * 序号
	 */
    private Integer typeOneNum;
    /**
	 * 备注
	 */
    private String typeOneRemark;

}