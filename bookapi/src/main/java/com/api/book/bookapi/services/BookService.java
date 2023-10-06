package com.api.book.bookapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bookapi.dao.BookRepository;
import com.api.book.bookapi.model.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list=new ArrayList<>();
    // //Adding a Books
    // static{
    //     list.add(new Book(12,"python","Shiv"));
    //     list.add(new Book(14,"Java Complete","Tech"));
    //     list.add(new Book(16,"HTML","Prakash"));
    //     list.add(new Book(18,"CSS","Vipin"));
    // }
   //Get a All Books
    public List<Book> gettAllBooks(){
        List<Book> list=(List<Book>) this.bookRepository.findAll();
        return list;
    }

    //Get a single book
    public Book getBookById(int id)
    {
        Book book=null;
        try{
            // book= list.stream().filter(e->e.getId()==id).findFirst().get(); book= list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
            
        }
       return book;
        
    }

    //Adding the book
    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }

    //Delete book
    public void deleteBook(int bid){
        //list =list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //Update The Book
    public void updateBook(Book book,int bookId){
        // list=list.stream().map(b->{
        //     if(b.getId()==bookId){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }

        //     return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        
        bookRepository.save(book);
    }
    
}
