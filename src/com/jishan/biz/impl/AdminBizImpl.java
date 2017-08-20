package com.jishan.biz.impl;

import com.jishan.biz.IAdminBiz;
import com.jishan.dao.IAdminDao;
import com.jishan.dao.impl.IAdminDaoImpl;
import com.jishan.entity.Admin;

public class AdminBizImpl implements IAdminBiz {
	IAdminDao dao ;
	public AdminBizImpl(){
		dao = new IAdminDaoImpl() ;
	}
	
	@Override
	public Admin showAdminByName(String adminname) {
		
		return dao.showAdminByName(adminname);
	}

}
