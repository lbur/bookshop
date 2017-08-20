package com.jishan.biz;
import com.jishan.entity.User;
import java.util.List;
public interface IUserBiz {
	public void AddUser(User user) ;
	public User showUserByName(String username) ;
	public List<User> showUserListByPage(int pageNo, int pageSize);	
	public List<User> showUserList() ;
	public void deleteUser(int uid);
	public void updateUser(User user);
	
	public User showUserById(int uid);
}
