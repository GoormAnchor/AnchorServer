package anchor.book.service;

import anchor.book.entity.User;
import anchor.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User findByUserSeq(Long userSeq) {
        Optional<User> userOptional = userRepository.findById(userSeq);
        return userOptional.get();
    }

}
