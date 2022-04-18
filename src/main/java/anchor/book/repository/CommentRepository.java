package anchor.book.repository;

import anchor.book.entity.Comment;
import anchor.book.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /*
    data jpa가 기본 제공하는 함수는 아니지만 jpa의 함수 규칙을 이용하면 커스텀 쿼리 없이도 사용가능합니다.
    다만 서비스에서 사용하기 위해서 리포지토리에 선언해줬습니다.
     */
    List<Comment> findCommentsByEpisode_Book_Id(long book_id);
    List<Comment> findCommentsByEpisode(Optional<Episode> episode);
}