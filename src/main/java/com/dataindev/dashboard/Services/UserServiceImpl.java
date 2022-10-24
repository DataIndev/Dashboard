package com.dataindev.dashboard.Services;

import com.dataindev.dashboard.Entity.User;
import com.dataindev.dashboard.Entity.UserPermissions;
import com.dataindev.dashboard.Repository.PermissionRepository;
import com.dataindev.dashboard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public User createUser(User user, Set<UserPermissions> userPermissions) throws Exception {

        User newUser = userRepository.findByuserName(user.getUserName());
        if(newUser != null){
            System.out.println("Usuario Existente");
            throw new Exception("Usuario Existente");
        }
        else{
            for(UserPermissions permissions : userPermissions){
                permissionRepository.save(permissions.getPermission());
            }
            user.getUserPermissions().addAll(userPermissions);
            newUser = userRepository.save(user);

        }
        return newUser;

    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByuserName(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
