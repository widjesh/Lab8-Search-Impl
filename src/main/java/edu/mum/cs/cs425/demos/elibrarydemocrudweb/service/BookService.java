package edu.mum.cs.cs425.demos.elibrarydemocrudweb.service;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public abstract Iterable<Book> getAllBooks();
    public abstract Book saveBook(Book book);
    public abstract Book getBookById(Integer bookId);
    public abstract void deleteBookById(Integer bookId);
    public abstract Page<Book> getAllBooksPaged(int nuPage);
    public abstract Page<Book> getAllBooksPagedFiltered(int nuPage,String filter);

    Optional<Book> getBookByISBN(String isbn);
}
