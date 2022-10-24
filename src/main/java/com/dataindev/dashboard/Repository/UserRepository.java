package com.dataindev.dashboard.Repository;

import com.dataindev.dashboard.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByuserName(String username);
}
