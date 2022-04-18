package anchor.book.repository;

import anchor.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {
    /*
    제목에 검색어가 포함된 리스트를 찾기 위한 커스텀 쿼리
     */
    @Query("select b from Book b where b.name like %?1%")
    List<Book> findAllByName(String str);
}