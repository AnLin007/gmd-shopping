package com.springcloud.dao;

import com.springcloud.entity.Goods;
import java.util.List;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer goodsId);

	int insert(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);

	List<Goods> selectAll();

	int updateByPrimaryKey(Goods record);

	/**
	 * 查询Goods表中满足条件的商品信息
	 * 
	 * @param goods 查询条件
	 * @return 成功返回java.util.List 类型的实例，否则返回null
	 */
	public abstract List<Goods> select(Goods goods);

	/**
	 * 根据条件修改goods表 中指定goods_id的信息
	 * 
	 * @param goods 修改商品信息
	 * @return 成功返回大于0 的整数，否则返回小于0的整数
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 查询销量前十的商品信息
	 * 
	 * @return	成功返回java.util.List 类型的实例，否则返回null
	 */
	public abstract List<Goods> selectGroup();
}