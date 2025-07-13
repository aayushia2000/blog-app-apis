package com.ag.blog_app_apis.controllers;

import com.ag.blog_app_apis.payloads.ApiResponse;
import com.ag.blog_app_apis.payloads.UserDTO;
import com.ag.blog_app_apis.payloads.UserResponse;
import com.ag.blog_app_apis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createUserDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer userId) {
        UserDTO updateUser = this.userService.updateUser(userDTO, userId);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
//        return new ResponseEntity<>(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }

    //get aLll
    @GetMapping("/")
    public ResponseEntity<UserResponse> getAllUsers(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                    @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                                    @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
                                                    @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        UserResponse allUsers = this.userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<UserResponse>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
