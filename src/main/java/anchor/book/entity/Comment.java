package anchor.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private long id;

    private LocalDateTime created_at;
    private String content;

    //fk
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns( {
            @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            @JoinColumn(name = "episode_num", referencedColumnName = "episode_num"),
    }
    )
    private Episode episode;
//    private long book_id;


}
