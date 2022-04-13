package anchor.book.request;

import lombok.Data;

@Data
public class CommentCreationRequest {
    private long user_seq; //유저 번호
    private String content;
    private long book_id;
    private Long episode_num;
}
