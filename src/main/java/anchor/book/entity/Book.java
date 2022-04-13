package anchor.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id @GeneratedValue
    @Column(name = "book_id")
    private long id;

    @Column(name = "book_name")
    private String name;

    @Column
    private String author;

    @Column
    private String book_url;

    @Column
    private String isbn;
    private String publisher;
    private Long price;

    //시리즈
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private Series series;
    private Long series_num;

    private LocalDateTime created_at;


}
