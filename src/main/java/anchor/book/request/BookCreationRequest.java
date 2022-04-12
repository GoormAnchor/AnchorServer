package anchor.book.request;

import anchor.book.entity.Series;
import lombok.Data;

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
