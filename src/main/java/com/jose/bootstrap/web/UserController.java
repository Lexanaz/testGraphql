package com.jose.bootstrap.web;

import com.jose.bootstrap.entity.User;
import com.jose.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userService.retrieveUser();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<List<String>> getUserInfo() {
        List<String> list = userService.retrieveUserInfo();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{iduser}/info")
    public ResponseEntity<String> getInfoByID(@PathVariable Long iduser) {
        String info = userService.retrieveUserInfoByIduser(iduser);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getUserNames() {
        List<String> list = userService.retrieveUserName();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
