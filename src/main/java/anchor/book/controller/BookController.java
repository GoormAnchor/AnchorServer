package anchor.book.controller;

import anchor.book.entity.Book;
import anchor.book.entity.Series;
import anchor.book.request.BookCreationRequest;
import anchor.book.request.SeriesCreationRequest;
import anchor.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController // rest api 컨트롤러 어노테이션
@RequestMapping(value = "api/book") //이 클래스의 api url은 localhost/api/book/으로 시작됨
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    /*
    모든 책 리스트 리턴.
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findBooks() {
        return ResponseEntity.ok(bookService.findBooks());
    }

    /*
    모든 시리즈 리스트 리턴
     */
    @GetMapping("/findAllSeries")
    public ResponseEntity<List<Series>> findSeries() {
        return ResponseEntity.ok(bookService.findSeries());
    }

    /*
    책 추가 api. (post 요청 - @RequestBody 어노테이션으로 http 바디 내용 인식)
    ! 개발중
     */
    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook (@RequestBody BookCreationRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }
    /*
    시리즈 추가 api. (POST)
     */
    @PostMapping("/createSeries")
    public ResponseEntity<Series> createSeries (@RequestBody SeriesCreationRequest request) {
        return ResponseEntity.ok(bookService.createSeries(request));
    }
    /*
    책 id로 책 정보 검색 api.
    인풋 : 요청 url (get - url의 id 파라미터를 @RequestParam 어노테이션으로 인식)
    아웃풋: 책 정보
     */
    @GetMapping("/find/id")
    public ResponseEntity<Book> findBookById(@RequestParam long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }
    /*
    책 이름 검색 api
    제목에 검색어가 포함된 책 정보 리스트 리턴
     */
    @GetMapping("/find/name")
    public ResponseEntity<List<Book>> findBookListByName(@RequestParam String containWord) {
        return ResponseEntity.ok(bookService.findBookListByName(containWord));
    }

    /*
    시리즈 내의 모든 책 리스트 리턴
     */
    @GetMapping("/find/series")
    public ResponseEntity<List<Book>> findBookBySeries(@RequestParam Long id) {
        return ResponseEntity.ok(bookService.findBookBySeries(id));
    }

    /*
    유저가 코멘트 작성한 책 리스트 조회
     */
    @GetMapping("/commentedBook")
    public ResponseEntity<List<Book>> findCommentedSeries(@RequestParam Long userSeq) {
        return ResponseEntity.ok(bookService.findCommentedBookId(userSeq));
    }
}
