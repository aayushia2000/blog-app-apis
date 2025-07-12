package com.ag.blog_app_apis.services.Impl;

import com.ag.blog_app_apis.entities.User;
import com.ag.blog_app_apis.exceptions.ResourceNotFoundException;
import com.ag.blog_app_apis.payloads.UserDTO;
import com.ag.blog_app_apis.repositories.UserRepo;
import com.ag.blog_app_apis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user.setName(userDTO.getName());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        User updatedUser = this.userRepo.save(user);


        return this.userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = this.userRepo.findAll();
        List<UserDTO> userDTOList = userList.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDTOList;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(user);

    }

//    private User dtoToUser(UserDTO userDTO){
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setAbout(userDTO.getAbout());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        return user;
//    }

    private User dtoToUser(UserDTO userDTO){
        User user = this.modelMapper.map(userDTO, User.class);
        return user; //we can directly return this.modelMapper.map(useRDTO, User.class);
    }

//    private UserDTO userToDto(User user){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setName(user.getName());
//        userDTO.setAbout(user.getAbout());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        return userDTO;
//    }
    private UserDTO userToDto(User user){
        return this.modelMapper.map(user, UserDTO.class);
    }
}
