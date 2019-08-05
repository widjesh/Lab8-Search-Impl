package edu.mum.cs.cs425.demos.elibrarydemocrudweb.repository;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByIsbn(String isbn);
    Page<Book> findBooksByTitleContainsOrIsbnContainsOrPublisherContains(String title,String isbn,String publisher, Pageable pageable);
    // This interface definition relies on the public abstract methods
    // inherited from the super interface, CrudRepository<T, ID>
    // We may override any or add more methods here, if needed.
}
