package com.jose.bootstrap.service;


import com.jose.bootstrap.entity.User;
import com.jose.bootstrap.exception.UserNotFoundException;
import com.jose.bootstrap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> retrieveUser() {
        return (List<User>) userRepository.findAll();
    }

    public List<String> retrieveUserInfo() {
        return userRepository.findAllInfo();
    }

    public String retrieveUserInfoByIduser(Long iduser) {
        Optional<String> optionalInfo = Optional.ofNullable(userRepository.findInfoByIduser(iduser));
        return optionalInfo.orElseThrow(UserNotFoundException::new);
    }
    public List<String> retrieveUserName() {
        return userRepository.findAllName();
    }



}
