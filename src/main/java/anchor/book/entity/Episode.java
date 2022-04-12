package anchor.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "episode")
public class Episode {
    @EmbeddedId
    private EpisodeId id;

    @MapsId("book_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private String episode_name;
}
