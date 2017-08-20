package com.jishan.biz.impl;

import com.jishan.biz.IUserloginBiz;
import com.jishan.dao.IUserloginDao;
import com.jishan.dao.impl.IUserloginDaoImpl;
import com.jishan.entity.User;

public class UserloginBizImpl implements IUserloginBiz {
	IUserloginDao dao ;
	public UserloginBizImpl(){
		dao = new IUserloginDaoImpl() ;
	}
	
	@Override
	public User showUserByName(String username) {
		
		return dao.showUserByName(username);
	}

}
