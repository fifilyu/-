package com.cdgeekcamp.shijianxing.service;

import com.cdgeekcamp.shijianxing.dto.UserDto;
import com.cdgeekcamp.shijianxing.model.Role;
import com.cdgeekcamp.shijianxing.model.User;
import com.cdgeekcamp.shijianxing.repository.RoleRepository;
import com.cdgeekcamp.shijianxing.repository.UserRepository;
import com.cdgeekcamp.shijianxing.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(
                userDto.getName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword()),
                List.of(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
