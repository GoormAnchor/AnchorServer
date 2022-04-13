package anchor.book.controller;

import anchor.book.entity.Comment;
import anchor.book.request.CommentCreationRequest;
import anchor.book.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    @GetMapping("/findAll")
    public ResponseEntity<List<Comment>> findComments() {
        return ResponseEntity.ok(commentService.findAllComments());
    }

    @GetMapping("/find")
    public ResponseEntity<List<Comment>> findCommentsByBook(@RequestParam long bookId) {
        return ResponseEntity.ok(commentService.findCommentsByBook(bookId));
    }

    @PostMapping("/createComment")
    public ResponseEntity<Comment> createComment (@RequestBody CommentCreationRequest request){
        return ResponseEntity.ok(commentService.createComment(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
