package anchor.book;

import anchor.book.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class userTest {

    @Test
    public void userEntityTest() {
        User user = new User();

        LocalDateTime date = LocalDateTime.now();

        user.setUserSeq(4L);
        user.setUserId("hohoho");
        user.setUsername("김철수");
        user.setPassword("1234");
        user.setEmail("rlacjftn@naver.com");
        user.setEmail("N");
        user.setProfileImageUrl("nothing");
        user.setProviderType("google");
        user.setRoleType("admin");
        user.setCreatedAt(date);
        user.setModifiedAt(date);

        System.out.println(user.getUserId());
    }

}
