package br.com.apss.userserviceapi.user.domain.User;

import lombok.RequiredArgsConstructor;
import model.enums.ProfileEnum;
import model.responses.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse findById(String id) {
        return userMapper.toResponse(userRepository.findById(id).orElse(null));
    }

    public UserResponse saveUser() {
        User user1 = new User();
        user1.setName("Adilson Paraguai");
        user1.setEmail("apdr@gmail.com");
        user1.setPassword("12344");
        user1.setProfiles(Collections.singleton(ProfileEnum.ROLE_ADMIN));
        return userMapper.toResponse(userRepository.save(user1));
    }

}
