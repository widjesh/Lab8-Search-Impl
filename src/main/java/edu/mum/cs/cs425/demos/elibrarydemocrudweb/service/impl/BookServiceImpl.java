package edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.impl;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.repository.BookRepository;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository repository;
    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    
    private final Sort sortable = Sort.by("title","isbn");

    @Override
    public Iterable<Book> getAllBooks() {
        return repository.findAll(sortable);
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public Page<Book> getAllBooksPaged(int nuPage) {
        return repository.findAll(PageRequest.of(nuPage,5,sortable));
    }

    @Override
    public Page<Book> getAllBooksPagedFiltered(int nuPage, String filter) {
        return repository.findBooksByTitleContainsOrIsbnContainsOrPublisherContains(filter,filter,filter,PageRequest.of(nuPage,5,sortable));
    }

    @Override
    public Optional<Book> getBookByISBN(String isbn) {
        return repository.findBookByIsbn(isbn);
    }

}
