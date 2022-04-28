package anchor.book.controller;

import anchor.book.request.LikesCreationRequest;
import anchor.book.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value = "api/likes")
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    // 코멘트의 모든 좋아요 반환
    @GetMapping("/comment")
    public ResponseEntity findLike(@RequestParam Long commentId) {
        return ResponseEntity.ok(likesService.findLikes(commentId));
    }

    // 좋아요 생성
    @PostMapping("/createLike")
    public ResponseEntity createLike(@RequestBody LikesCreationRequest request) {
        return ResponseEntity.ok(likesService.createLike(request));
    }

    // 좋아요 삭제
    // TODO 컴파일은 되지만 동작이안됨
    @DeleteMapping("/delete/{commentId}/{userSeq}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId, Long userSeq){
        likesService.deleteLike(commentId, userSeq);
        return ResponseEntity.ok().build();
    }
}
