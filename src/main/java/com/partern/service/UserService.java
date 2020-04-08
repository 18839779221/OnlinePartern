package com.partern.service;

import com.partern.bean.User;
import com.partern.responsebo.responseenitiy.ResponseEntity;

public interface UserService {

    ResponseEntity login(String uId, String uPassword);

    ResponseEntity getUsers();

    ResponseEntity register(User user);

    ResponseEntity getUserById(String phone);

    ResponseEntity getFansListById(String uId);

    ResponseEntity getConcernListById(String uId);

    ResponseEntity getFansAndConcernListById(String uId);

    ResponseEntity getRecommmendUser(int i);

    ResponseEntity searchUserByIdOrNick(String searchText);

    ResponseEntity updateLike(String phone,int like);
}
