package anchor.book.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Progress {
/*
    @EmbeddedId
    private ProgressId id;

    @Transient
    @MapsId("series_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    private Series series;

    @MapsId("user_seq")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @MapsId("comment_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    @Transient
    private Long seriesId;

    @Transient
    private Long userSeq;
*/
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private Long progressRate;

}