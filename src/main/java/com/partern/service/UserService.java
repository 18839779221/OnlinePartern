package com.partern.service;

import com.partern.bean.User;
import com.partern.responsebo.ResponseEntity;

public interface UserService {

    ResponseEntity login(String uId, String uPassword);

    ResponseEntity getUsers();

    ResponseEntity register(User user);

    ResponseEntity getUserById(String phone);
}
