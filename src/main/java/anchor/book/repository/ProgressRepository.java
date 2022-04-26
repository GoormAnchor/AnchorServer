package anchor.book.repository;

import anchor.book.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgressRepository extends JpaRepository <Progress, Long> {
    @Query("select abs((select max(b.series_num) from Book b join Comment c on b.id=c.book where b.series.id=(select b.series.id from Book b where b.id=:bookId) and c.user.user_seq=:userSeq) / (select max(b.series_num) from Book b where b.series.id=(select b.series.id from Book b where b.id=:bookId)) * 100)")
    Progress getProgressRate(Long bookId, Long userSeq);


}
