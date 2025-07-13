package com.ag.blog_app_apis.services;

import com.ag.blog_app_apis.payloads.UserDTO;
import com.ag.blog_app_apis.payloads.UserResponse;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO, Integer userId);
    UserDTO getUserById(Integer userId);
    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    void deleteUser(Integer userId);

}
