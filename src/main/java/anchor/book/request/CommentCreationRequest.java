package anchor.book.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentCreationRequest {
    private Long user_seq; //유저 번호
    private String content;
    private Long book_id = 1L;
    private Long episode_id;
    private LocalDateTime created_at = LocalDateTime.now();
    private Long likes = 0L;
}
