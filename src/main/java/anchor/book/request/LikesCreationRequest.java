package anchor.book.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LikesCreationRequest {
    private Long comment;
    private Long user;
    private LocalDateTime created_at = LocalDateTime.now();
}
