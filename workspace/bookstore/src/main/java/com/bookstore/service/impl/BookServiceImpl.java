package com.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookId(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public Book createBook(Book request) {
		return bookRepository.save(request);
	}

	@Override
	public Book updateBook(Long id, Book request) {
		Book bookOld = getBookId(id);	
		return bookRepository.save(verifyPropertiesModified(bookOld, request));
	}



	@Override
	public void deleteBook(Long id) {
		getBookId(id);
		bookRepository.deleteById(id);
	}
	
	private Book verifyPropertiesModified(Book bookOld, Book request) {
		Book bookModified = new Book();
		bookModified.setId(bookOld.getId());
		bookModified.setName((bookOld.getName().equals(request.getName())) ? bookOld.getName() : request.getName());
		bookModified.setPrice((bookOld.getPrice().equals(request.getPrice())) ? bookOld.getPrice() : request.getPrice());
		bookModified.setCategory((bookOld.getCategory().equals(request.getCategory())) ? bookOld.getCategory() : request.getCategory());
		bookModified.setQuantity((bookOld.getQuantity().equals(request.getQuantity())) ? bookOld.getQuantity() : request.getQuantity());
		bookModified.setImg((bookOld.getImg().equals(request.getImg())) ? bookOld.getImg() : request.getImg());
		return bookModified;
	}
}
