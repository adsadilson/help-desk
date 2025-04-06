package br.com.apss.userserviceapi.user.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Locale findByEmail(String email);
}
