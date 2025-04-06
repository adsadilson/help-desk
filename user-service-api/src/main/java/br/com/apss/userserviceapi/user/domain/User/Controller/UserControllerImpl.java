package br.com.apss.userserviceapi.user.domain.User.Controller;

import br.com.apss.userserviceapi.user.domain.User.UserService;
import lombok.RequiredArgsConstructor;
import model.responses.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> findById(String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
}
