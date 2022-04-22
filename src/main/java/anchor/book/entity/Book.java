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
    private Long id;

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
    private String book_image;

    //시리즈
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "series_id")
    private Series series;
    private Long series_num;

    private LocalDateTime created_at;


}
