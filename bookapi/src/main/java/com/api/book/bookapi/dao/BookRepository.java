package com.api.book.bookapi.dao;
import com.api.book.bookapi.model.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Integer>{
    
	public Book findById(int id);
	
}
