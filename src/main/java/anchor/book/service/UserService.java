package anchor.book.service;

import anchor.book.entity.User;
import anchor.book.repository.BookRepository;
import anchor.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public User findByUserSeq(Long userSeq) {
        Optional<User> user = userRepository.findById(userSeq);
        if(!user.isPresent()){
            throw new NoSuchElementException("조회할 유저가 없습니다");
        }
        return user.get();
    }

}
