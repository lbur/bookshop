package com.jishan.dao;

import java.util.List;

import com.jishan.entity.Cart;

public interface ICartDao {
	//����һ��������Ϣ�����ﳵ��
	public void saveCart(Cart cart) ;
	
	//�����û�id���鼮id��ѯ���ﳵ��¼
	public  Cart showCartById(int userId ,int  bNum);
	
	//���¹��ﳵ���¼
	public void updateCart(Cart cart);
	
	//��ʾĳ���û������й��ﳵ��¼
	public List<Cart> showCartList(int userid) ;
	
	//�����û�id���鼮idɾ��ĳ�����ﳵ��¼
	public void deleteCart(int userid ,int bnum) ;
}
