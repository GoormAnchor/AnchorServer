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
    //id로 책 검색
    public Book findBookById(long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new EntityNotFoundException("해당 id를 가진 책이 존재하지 않습니다. book_id : "+ id);
        }
        return bookOptional.get();
    }

    //이름 포함한 책리스트 리턴
    public List<Book> findBookListByName(String str) {
        List<Book> list = bookRepository.findAllByName(str);

        return list;
    }
    //시리즈 저장
    public Series createSeries(SeriesCreationRequest series) {
        Series seriesToCreate = new Series();
        BeanUtils.copyProperties(series, seriesToCreate);
        seriesToCreate.setName(series.name);
        return seriesRepository.save(seriesToCreate);
    }

    public List<Series> findSeries() {
        return seriesRepository.findAll();
    }

    //시리즈 내의 모든 책 리스트 리턴
    public List<Book> findBookBySeries(Long id) {
        List<Book> list = bookRepository.findAllBySeriesIs(id);

        return list;
    }
}
