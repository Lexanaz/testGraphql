package com.jose.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jose.bootstrap.entity.User;
import com.jose.bootstrap.exception.UserNotFoundGraphQLException;
import com.jose.bootstrap.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {
    private final UserRepository userRepository;

    public UserQuery(UserRepository userRepository) { this.userRepository = userRepository; }

    public Iterable<User> findAllUsers() { return userRepository.findAll(); }

    public List<String> findUserInfo() { return userRepository.findAllInfo(); }

    public List<String> findAllUserNames() { return userRepository.findAllName(); }

    public String findUserInfoByIduser(Long iduser) { return userRepository.findInfoByIduser(iduser); }

    public User findUserByIduser(Long iduser) {
        Optional<User> optionalUser = userRepository.findByIduser(iduser);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundGraphQLException("User Not Found", iduser);
        }
    }

}
