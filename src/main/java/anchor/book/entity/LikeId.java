package anchor.book.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class LikeId implements Serializable {

    private long user_seq;
    private long comment_id;

    public LikeId(long user_seq, long comment_id){
        this.comment_id = comment_id;
        this.user_seq = user_seq;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass()!=o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(user_seq, likeId.user_seq) && Objects.equals(comment_id, likeId.comment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_seq, comment_id);
    }
}
