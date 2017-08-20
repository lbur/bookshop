package com.jishan.dao;

import java.util.List;

import com.jishan.entity.User;

public interface IUserDao {

	public void AddUser(User user);//新增
	/*public void SureUser(User user);*/

	//��ѯ�û���Ϣ	
	public User showUserByName(String username) ;//��ѯ
	//ÿҳ�涨��ʾpageSize�����ݣ���ѯ��PageNoҳ�����û����������List�ķ�ʽ����	
	public List<User> showUserListByPage(int pageNo,int pageSize);//��ѯ

//��ѯ�����û����������List�ķ�ʽ����		
	public List<User> showUserList() ; //��ѯ
	public void deleteUser(int uid);//ɾ���û�
	public void updateUser(User user);//�޸��û�
	
	public User showUserById(int uid);//ͨ��id��ѯ�û���Ϣ
}
