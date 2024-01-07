package com.example.Best.Buy.service.impl;

import com.example.Best.Buy.domain.User;
import com.example.Best.Buy.dto.UserDTO;
import com.example.Best.Buy.repository.CartRepository;
import com.example.Best.Buy.repository.UserRepository;
import com.example.Best.Buy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserImplService implements UserService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;

    public UserDTO save(UserDTO userDto) {
        User user= userRepository.save(toDo(userDto));
        return toDto(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Transactional
    public void deleteUser(Long id) {
        cartRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    public UserDTO update(UserDTO userDto, Long id) {
        Optional<User> userId=userRepository.findById(id);
        if (userId.isPresent()){
            User userUpdated=userRepository.findById(id).orElse(null);
            userUpdated.setName(userDto.getName());
            userUpdated.setEmail(userDto.getEmail());
            userUpdated.setCreatedAt(userDto.getCreatedAt());
            User user= userRepository.save(userUpdated);
            return toDto(user);
        }
        throw new RuntimeException("User not found on this id= " +id);
    }
    public User toDo(UserDTO UserDTO) {
        return modelMapper.map(UserDTO, User.class);
    }

    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
