package anchor.book.repository;

import anchor.book.entity.Comment;
import anchor.book.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByEpisode_Book_Id(long book_id);

    List<Comment> findCommentsByEpisode(Optional<Episode> episode);
}