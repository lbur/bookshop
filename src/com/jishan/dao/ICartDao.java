package com.jishan.dao;

import java.util.List;

import com.jishan.entity.Cart;

public interface ICartDao {
	//保存一条购物信息到购物车表
	public void saveCart(Cart cart) ;
	
	//根据用户id和书籍id查询购物车记录
	public  Cart showCartById(int userId ,int  bNum);
	
	//更新购物车表记录
	public void updateCart(Cart cart);
	
	//显示某个用户的所有购物车记录
	public List<Cart> showCartList(int userid) ;
	
	//根据用户id和书籍id删除某条购物车记录
	public void deleteCart(int userid ,int bnum) ;
}
