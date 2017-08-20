package com.jishan.dao;

import java.util.List;

import com.jishan.entity.User;

public interface IUserDao {

	public void AddUser(User user);//鏂板
	/*public void SureUser(User user);*/

	//查询用户信息	
	public User showUserByName(String username) ;//查询
	//每页规定显示pageSize条数据，查询第PageNo页所有用户，将结果以List的方式返回	
	public List<User> showUserListByPage(int pageNo,int pageSize);//查询

//查询所有用户，将结果以List的方式返回		
	public List<User> showUserList() ; //查询
	public void deleteUser(int uid);//删除用户
	public void updateUser(User user);//修改用户
	
	public User showUserById(int uid);//通过id查询用户信息
}
