package anchor.book.service;

import anchor.book.entity.Book;
import anchor.book.entity.Series;
import anchor.book.repository.BookRepository;
import anchor.book.repository.SeriesRepository;
import anchor.book.request.BookCreationRequest;
import anchor.book.request.SeriesCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final SeriesRepository seriesRepository;

    //책 전체 조회
    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    //책 저장
    public Book createBook(BookCreationRequest book) {
        //TODO: 검증 코드 구현
        Optional<Series> seriesOptional = seriesRepository.findById(book.getSeries_id());
        if (!seriesOptional.isPresent()) {
            throw new EntityNotFoundException(
                    "series Not Found");
        }
        Book bookToCreate = new Book();
        BeanUtils.copyProperties(book, bookToCreate);
      //  bookToCreate.setSeries(seriesOptional);
        return bookRepository.save(bookToCreate);
    }

    //시리즈 저장
    public Series createSeries(SeriesCreationRequest series) {
        Series seriesToCreate = new Series();
        BeanUtils.copyProperties(series, seriesToCreate);
        seriesToCreate.setName(series.name);
        return seriesRepository.save(seriesToCreate);
    }
}
