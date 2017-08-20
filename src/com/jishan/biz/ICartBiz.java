package com.jishan.biz;

import java.util.List;

import com.jishan.entity.Cart;

public interface ICartBiz {
	public void saveCart(Cart cart) ;
	
	public  Cart showCartById(int userId ,int bNum) ;
	
	public void updateCart(Cart cart) ;
	
	public List<Cart> showCartList(int userid);
	
	public void deleteCart(int userid, int bnum);
}
