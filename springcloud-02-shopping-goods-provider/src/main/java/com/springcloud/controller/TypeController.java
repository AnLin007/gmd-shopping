package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.TypeOne;
import com.springcloud.entity.TypeTwo;
import com.springcloud.service.TypeService;
import com.springcloud.vo.ResultValue;

/**
 * 一级类别与二级类别的控制器
 * 
 * @author DELL
 *
 */
@RestController
@RequestMapping("type")
public class TypeController {
	@Autowired
	private TypeService typeService;

	@RequestMapping(value = "/selectAll")
	public ResultValue selectAll() {
		ResultValue rv = new ResultValue();

		try {
			// 调用service中相应的方法查询所有一级类别的信息，并保存查询结果 NullPointerExcetion
			List<TypeOne> list = this.typeService.selectAllTypeOne();
			// 如果成功 &&:短路与 &：逻辑与
			if (list != null && list.size() > 0) {
				// 设置结果状态位0
				rv.setCode(0);
				// 创建map集合保存查询结果
				Map<String, Object> map = new HashMap<>();
				// 将查询结果保存到map集合里
				map.put("typeOneList", list);
				// 将map集合添加到ResultValue对象中
				rv.setDataMap(map);
				// 返回 ResultValue对象
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	@RequestMapping(value = "/selectById")
	public ResultValue selectById(@RequestParam("typeOneId") Integer typeOneId) {
		ResultValue rv = new ResultValue();
		try {
			// 调用service中相应的方法查询二级类别的信息，并保存查询结果
			List<TypeTwo> list = this.typeService.selectTypeTwoByTypeOneId(typeOneId);
			// 如果成功
			if (list != null && list.size() > 0) {
				// 设置结果状态位0
				rv.setCode(0);
				// 创建map集合保存查询结果
				Map<String, Object> map = new HashMap<>();
				// 将查询结果保存到map集合里
				map.put("typeTwoList", list);
				// 将map集合添加到ResultValue对象中
				rv.setDataMap(map);
				// 返回 ResultValue对象
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

}
