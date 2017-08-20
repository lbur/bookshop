package com.jishan.dao;

import java.util.List;
import com.jishan.entity.Collection;

public interface ICollectionDao {
	//����һ��������Ϣ�����ﳵ��
	public void saveCollection(Collection collection) ;
	//�����û�id���鼮id��ѯ���ﳵ��¼
	public  Collection showCollectionById(int userId ,int  bNum);
	
	//���¹��ﳵ���¼
	public void updateCollection(Collection collection);
	
	//��ʾĳ���û������й��ﳵ��¼
	public List<Collection> showCollectionList(int userid) ;
	//void saveCollection();

	public void deleteCollection(int userid, int bnum);
}
