package com.jishan.biz;

import java.util.List;

import com.jishan.entity.Book;

public interface IBookBiz {
		//��ѯ�鼮�б�
		public List<Book> showBookList();
		//��ѯͯ���б�
		public List<Book> showChildrenBookList();
		//�����鼮id ɾ���鼮
		public void deleteBookById(int bnum);
		
		//�����鼮id ��ѯ�鼮
		public Book showBookById(int bnum) ;
		//�����鼮����ģ����ѯ�鼮
		public Book showBookByName(String bname) ;
		//�����鼮
		public void updateBook(Book book) ;
      //�����鼮
		public void saveBook(Book book);
		//��ѯС˵�б�
		public List<Book> showNovelBookList();
		
		public List<Book> showTeachBookList();
		
		public List<Book> showHistoryBookList();
		
		public List<Book> showYoungBookList();
		
		public List<Book> showSuccessBookList();
		
		public List<Book> showTechnologyBookList();
		
		public List<Book> showReligionBookList();
		public List<Book> showSearchBookList(String bname);
}
