package com.jishan.biz;

import java.util.List;

import com.jishan.entity.Book;

public interface IBookBiz {
		//查询书籍列表
		public List<Book> showBookList();
		//查询童书列表
		public List<Book> showChildrenBookList();
		//根据书籍id 删除书籍
		public void deleteBookById(int bnum);
		
		//根据书籍id 查询书籍
		public Book showBookById(int bnum) ;
		//根据书籍名字模糊查询书籍
		public Book showBookByName(String bname) ;
		//更新书籍
		public void updateBook(Book book) ;
      //保存书籍
		public void saveBook(Book book);
		//查询小说列表
		public List<Book> showNovelBookList();
		
		public List<Book> showTeachBookList();
		
		public List<Book> showHistoryBookList();
		
		public List<Book> showYoungBookList();
		
		public List<Book> showSuccessBookList();
		
		public List<Book> showTechnologyBookList();
		
		public List<Book> showReligionBookList();
		public List<Book> showSearchBookList(String bname);
}
