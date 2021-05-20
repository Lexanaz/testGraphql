package com.jose.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jose.bootstrap.entity.User;
import com.jose.bootstrap.exception.UserNotFoundGraphQLException;
import com.jose.bootstrap.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMutation implements GraphQLMutationResolver {
    private final UserRepository userRepository;

    public UserMutation(UserRepository userRepository) { this.userRepository = userRepository; }

    public boolean deleteUserInfo(String info) {
        Integer result = userRepository.deleteUserByInfo(info);
        return result != 0;
    }

    public User updateUserName(String newName, Long iduser) {
        Optional<User> optionalUser =
                userRepository.findById(iduser);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(newName);
            userRepository.save(user);
            return user;
        } else {
            throw new UserNotFoundGraphQLException("User Not Found", iduser);
        }
    }
}