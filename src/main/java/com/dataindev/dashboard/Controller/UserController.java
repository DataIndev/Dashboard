package com.dataindev.dashboard.Controller;

import com.dataindev.dashboard.Entity.Permission;
import com.dataindev.dashboard.Entity.User;
import com.dataindev.dashboard.Entity.UserPermissions;
import com.dataindev.dashboard.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User saveUser(@RequestBody User user) throws Exception {
        Set<UserPermissions> permissionsSet = new HashSet<>();
        Permission permission = new Permission();
        permission.setId(1L);
        permission.setPermissionName("ADMIN");

        UserPermissions userPermissions = new UserPermissions();
        userPermissions.setUser(user);
        userPermissions.setPermission(permission);

        return userService.createUser(user,permissionsSet);

    }

    @GetMapping("/get/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
