package anchor.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime created_at;

    private String content;

    //fk
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_seq")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
//    @JsonIgnore
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "episode_id", referencedColumnName = "episode_id")
    private Episode episode;

    private Long likes = 0L;
//    private long book_id;


}
