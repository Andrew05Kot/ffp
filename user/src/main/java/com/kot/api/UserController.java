package com.kot.api;

import com.kot.entity.UserEntity;
import com.kot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers(
            @RequestParam(value = "pageIndex") int pageIndex,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "search", required = false) String search) {
        return userService.getUsersPage(PageRequest.of(pageIndex, pageSize), search).stream().map(UserResponse::new).toList();
    }

    @PostMapping
    public UserResponse createUSer(@RequestBody UserEntity user) {
        return new UserResponse(userService.createUser(user));
    }
}
