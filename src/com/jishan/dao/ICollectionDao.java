package com.jishan.dao;

import java.util.List;
import com.jishan.entity.Collection;

public interface ICollectionDao {
	//保存一条购物信息到购物车表
	public void saveCollection(Collection collection) ;
	//根据用户id和书籍id查询购物车记录
	public  Collection showCollectionById(int userId ,int  bNum);
	
	//更新购物车表记录
	public void updateCollection(Collection collection);
	
	//显示某个用户的所有购物车记录
	public List<Collection> showCollectionList(int userid) ;
	//void saveCollection();

	public void deleteCollection(int userid, int bnum);
}
