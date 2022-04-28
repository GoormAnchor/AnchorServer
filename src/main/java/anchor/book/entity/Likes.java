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
@Table(name = "likes")
public class Likes {
    @EmbeddedId
    @JsonIgnore
    private LikeId id = new LikeId();

    @MapsId("user_seq")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @MapsId("comment_id")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime created_at;
}
