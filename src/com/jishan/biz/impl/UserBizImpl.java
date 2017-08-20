package com.jishan.biz.impl;
import java.util.List;
import com.jishan.biz.IUserBiz;
import com.jishan.dao.IUserDao;
import com.jishan.dao.impl.IUserDaoImpl;
import com.jishan.entity.User;

public class UserBizImpl implements IUserBiz{
	IUserDao dao ;
	public UserBizImpl(){
		dao = new IUserDaoImpl() ;
	}

	@Override
	public void AddUser(User user) {
		dao.AddUser(user);
		
	}
	@Override
	public User showUserByName(String username) {
		return dao.showUserByName(username) ;
	}
	@Override
	public List<User> showUserListByPage(int pageNo, int pageSize) {
		return dao.showUserListByPage(pageNo, pageSize);
	}

	@Override
	public List<User> showUserList() {
		
		return dao.showUserList();
	}

	@Override
	public void deleteUser(int uid) {
		dao.deleteUser(uid);
		
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	@Override
	public User showUserById(int uid) {
		
		return dao.showUserById(uid);
	}
}
