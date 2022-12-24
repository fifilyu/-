package com.cdgeekcamp.demo.service;

import com.cdgeekcamp.demo.dto.UserDto;
import com.cdgeekcamp.demo.model.User;

public interface UserService {
    void save(UserDto userDto);

    User findUserByEmail(String email);
}
