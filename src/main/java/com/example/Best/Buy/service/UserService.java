package com.example.Best.Buy.service;

import com.example.Best.Buy.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDto);

    public List<UserDTO> getAllUsers();

    @Transactional
    public void deleteUser(Long id);
    public UserDTO update(UserDTO userDto, Long id);

    UserDTO login(UserDTO userDto);

}
