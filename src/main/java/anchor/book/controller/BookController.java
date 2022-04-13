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

@RestController
@RequestMapping(value = "api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findBooks(){
        return ResponseEntity.ok(bookService.findBooks());
    }

    @GetMapping("/findAllSeries")
    public ResponseEntity<List<Series>> findSeries(){
        return ResponseEntity.ok(bookService.findSeries());
    }

    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook (@RequestBody BookCreationRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @PostMapping("/createSeries")
    public ResponseEntity<Series> createSeries (@RequestBody SeriesCreationRequest request) {
        return ResponseEntity.ok(bookService.createSeries(request));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

}