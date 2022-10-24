package com.dataindev.dashboard.Services;

import com.dataindev.dashboard.Entity.User;
import com.dataindev.dashboard.Entity.UserPermissions;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserPermissions> userPermissions) throws Exception;

    public User getUser(String userName);

    public void deleteUser(Long userId);
}
