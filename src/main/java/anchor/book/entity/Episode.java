package anchor.book.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "episode")
public class Episode {
    @Id @GeneratedValue
    @Column(name = "episode_id")
    private Long episodeId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private String episode_name;
}
