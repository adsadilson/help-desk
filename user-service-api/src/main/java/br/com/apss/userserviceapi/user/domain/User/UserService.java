package br.com.apss.userserviceapi.user.domain.User;

import lombok.RequiredArgsConstructor;
import model.enums.ProfileEnum;
import model.exceptions.ResourceNotFoundException;
import model.responses.UserResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse findById(final String id) {
        return userMapper.toResponse(find(id));
    }

    private User find(final String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Object not found. Id: " + id + ", Type: " + UserResponse.class.getSimpleName()
                ));
    }

   /* private void verifyIfEmailAlreadyExists(final String email, final String id) {
        userRepository.findByEmail(email)
                .filter(user -> !user.getId().equals(id))
                .ifPresent(user -> {
                    throw new DataIntegrityViolationException("Email [ " + email + " ] already exists");
                });
    }*/

    public UserResponse saveUser() {
        User user1 = new User();
        user1.setName("Adilson Paraguai");
        user1.setEmail("apdr@gmail.com");
        user1.setPassword("12344");
        user1.setProfiles(Collections.singleton(ProfileEnum.ROLE_ADMIN));
        return userMapper.toResponse(userRepository.save(user1));
    }

}
