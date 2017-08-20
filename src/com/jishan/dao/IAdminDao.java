package com.jishan.dao;

import com.jishan.entity.Admin;

public interface IAdminDao {
	//根据名字  查询管理员信息
	public Admin showAdminByName(String adminname) ;
}
