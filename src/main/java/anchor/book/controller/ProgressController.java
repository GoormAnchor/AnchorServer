package anchor.book.controller;

import anchor.book.entity.Progress;
import anchor.book.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value = "api/progress")
@RequiredArgsConstructor
public class ProgressController {
    private final ProgressService progressService;

    //진행률 조회
    @GetMapping("/")
    public ResponseEntity<Progress> getProgressRate(@RequestParam Long bookId, @RequestParam Long userSeq) {
        return ResponseEntity.ok(progressService.getProgressRate(bookId, userSeq));
    }
}
