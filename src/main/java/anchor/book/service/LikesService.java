package anchor.book.service;

import anchor.book.entity.Comment;
import anchor.book.entity.Likes;
import anchor.book.entity.User;
import anchor.book.repository.CommentRepository;
import anchor.book.repository.LikesRepository;
import anchor.book.repository.UserRepository;
import anchor.book.request.LikesCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public List<Likes> findLikes(Long commentId) {
        List<Likes> list = likesRepository.findByCommentId(commentId);

        return list;
    }

    //좋아요 생성 api
    public Likes createLike(LikesCreationRequest request) {

        Optional<Comment> comment = commentRepository.findById(request.getComment());
        if (!comment.isPresent())
            throw new EntityNotFoundException("book_id Not Found");

        Optional<User> user = userRepository.findById(request.getUser());
        if (!user.isPresent())
            throw new EntityNotFoundException("user_seq Not Found");

        Likes LikeToCreate = new Likes();
        BeanUtils.copyProperties(request, LikeToCreate);
        LikeToCreate.setComment(comment.get());
        LikeToCreate.setUser(user.get());

        return likesRepository.save(LikeToCreate);
    }

    public void deleteLike(Long commentId, Long userSeq){
        likesRepository.deleteByCommentIdAndUserUserseq(commentId, userSeq);
    }
}
