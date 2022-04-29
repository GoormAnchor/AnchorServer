package anchor.book.controller;

import anchor.book.entity.Comment;
import anchor.book.request.CommentCreationRequest;
import anchor.book.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
* TODO: 개발중입니다. (테스트 x)
*
 */

@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@RestController
@RequestMapping(value = "api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    /*
    모든 코멘트 리스트 리턴
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Comment>> findComments() {
        return ResponseEntity.ok(commentService.findAllComments());
    }
    /*
    해당 id를 가진 책에 달린 코멘트 리스트 리턴
     */
    @GetMapping("/find")
    public ResponseEntity<List<Comment>> findCommentsByBook(@RequestParam long bookId) {
        return ResponseEntity.ok(commentService.findCommentsByBook(bookId));
    }
    /*
    유저 id별 코멘트 조회
     */
    @GetMapping("/find/userseq")
    public ResponseEntity<List<Comment>> findCommentsByUserSeq(@RequestParam Long userSeq) {
        return ResponseEntity.ok(commentService.findByUserSeq(userSeq));
    }
    /*
    코멘트 생성 api
     */
    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment (@RequestBody CommentCreationRequest request){
        return ResponseEntity.ok(commentService.createComment(request));
    }
    /*
    코멘트 삭제 api
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
