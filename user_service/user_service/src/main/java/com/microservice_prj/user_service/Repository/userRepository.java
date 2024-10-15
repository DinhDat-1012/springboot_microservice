package com.microservice_prj.user_service.Repository;

import com.microservice_prj.user_service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {
}
