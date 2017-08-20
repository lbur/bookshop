package com.jishan.dao;

import com.jishan.entity.Order;

public interface IOrderDao {
	//保存订单信息到订单表
	public void saveOrder(Order order) ;
}
