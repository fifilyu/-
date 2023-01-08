package com.cdgeekcamp.shijianxing.service;

import com.cdgeekcamp.shijianxing.dto.UserDto;
import com.cdgeekcamp.shijianxing.model.User;

public interface UserService {
    void save(UserDto userDto);

    User findUserByEmail(String email);
}
