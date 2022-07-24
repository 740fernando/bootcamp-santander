package com.bookstore.service;

import java.util.List;
import com.bookstore.model.Book;

public interface BookService {
	List<Book>  getBookList();
	Book getBookId(Long id);
	Book createBook(Book request);
	Book updateBook(Long id, Book request);
	void deleteBook(Long id);
}
