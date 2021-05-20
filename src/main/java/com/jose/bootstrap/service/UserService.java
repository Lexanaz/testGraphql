package com.jose.bootstrap.service;

import com.jose.bootstrap.entity.User;

import java.util.List;

public interface UserService {
    List<User> retrieveUser();
    List<String> retrieveUserInfo();
    String retrieveUserInfoByIduser(Long iduser);
    List<String> retrieveUserName();
}