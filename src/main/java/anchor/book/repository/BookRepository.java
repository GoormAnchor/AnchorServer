package anchor.book.repository;

import anchor.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    /*
    제목에 검색어가 포함된 리스트를 찾기 위한 커스텀 쿼리
     */
    @Query("select b from Book b where b.name like %?1%")
    List<Book> findAllByName(String str);

    @Query("select b from Book b where b.series.id=:id")
    List<Book> findAllBySeriesIs(Long id);

    //@Query("select max(series_num) from Book b where book.id=:bookId")
    //Long getMaxSeriesNum(Long bookId);

    @Query("select distinct b from Comment c join Book b on c.book=b.id and c.user.userseq=:userSeq")
    List<Book> findCommentedBookId(Long userSeq);
}
