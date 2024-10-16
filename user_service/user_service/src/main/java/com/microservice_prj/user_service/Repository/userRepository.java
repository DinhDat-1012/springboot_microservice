package com.microservice_prj.user_service.Repository;

import com.microservice_prj.user_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
    User findById(long id);
    User findByEmail(String email);
    User findByUsername(String username);
}
