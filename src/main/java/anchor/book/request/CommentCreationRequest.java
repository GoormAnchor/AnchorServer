package anchor.book.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentCreationRequest {
    private long user_seq; //유저 번호
    private String content;
    private long book_id;
    private Long episode_num;
    private LocalDateTime created_at = LocalDateTime.now();
}
