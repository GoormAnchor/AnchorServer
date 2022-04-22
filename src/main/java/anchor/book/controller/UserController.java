package anchor.book.controller;

import anchor.book.entity.User;
import anchor.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value = "api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/userinfo")
    public ResponseEntity<User> findUser(@RequestParam Long userSeq) {
        return ResponseEntity.ok(userService.findByUserSeq(userSeq));
    }
}
