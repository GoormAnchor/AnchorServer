package anchor.book.service;

import anchor.book.entity.Comment;
import anchor.book.entity.Episode;
import anchor.book.repository.CommentRepository;
import anchor.book.repository.EpisodeRepository;
import anchor.book.request.CommentCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final EpisodeRepository episodeRepository;

    //코멘트 전체 조회
    public List<Comment> findAllComments(){
        return commentRepository.findAll();
    }

    //책 별 코멘트 조회
    public List<Comment> findCommentsByBook(Long book_id){
        return commentRepository.findCommentsByBook_Id(book_id);
    }
    //에피소드 별 코멘트 조회
    public List<Comment> findCommentsByEpisode(long book_id, long episode_id){
        //TODO: 에피소드 찾기
        Optional<Episode> episode = episodeRepository.findById(episode_id);
        if(!episode.isPresent()){
            //에피소드가 없을 때
        }
        return commentRepository.findCommentsByEpisode(episode);
    }
    //유저 id별 코멘트 조회
    //TODO: 유저 추가 후 확인 필요
    //public List <Comment> findCommentsByUser(Long userSeq) {
    //    Optional
    //}

    //코멘트 추가
    public Comment createComment(CommentCreationRequest request){
        //TODO: request 검증
        Comment commentToCreate = new Comment();
        BeanUtils.copyProperties(request, commentToCreate);

        return commentRepository.save(commentToCreate);

    }

    //코멘트 삭제
    public void deleteComment(long commentId){
        commentRepository.deleteById(commentId);
    }
}
