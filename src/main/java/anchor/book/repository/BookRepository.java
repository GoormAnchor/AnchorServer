package anchor.book.repository;

import anchor.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.name like %?1%")
    List<Book> findAllByName(String str);
}