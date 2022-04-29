package anchor.book.repository;

import anchor.book.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {

    //@Query("delete from likes l where l.Comment.id=:commentId and l.User.userseq=:userSeq")
    void deleteByCommentIdAndUserUserseq(Long commentId, Long userSeq);

    List<Likes> findByCommentId(Long commentId);
}
