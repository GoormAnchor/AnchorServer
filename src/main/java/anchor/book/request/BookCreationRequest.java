package anchor.book.request;

import anchor.book.entity.Series;
import lombok.Data;
/*
책 생성 때 필요한 데이터들을 data 객체로 묶어줌
 */
@Data
public class BookCreationRequest {
    private long id;
    private String name;
    private String author;
    private String isbn;
    private String publisher;
    private long price;
    private long series_id;
    private long series_num;
}
