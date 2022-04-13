package anchor.book.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EpisodeId implements Serializable {

    private long book_id;
    private Long episode_num;

    public EpisodeId(long bookId, long episodeNum){
        this.book_id = bookId;
        this.episode_num = episodeNum;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass()!=o.getClass()) return false;
        EpisodeId episodeId1 = (EpisodeId) o;
        return episode_num == episodeId1.episode_num && Objects.equals(book_id, episodeId1.book_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, episode_num);
    }
}
