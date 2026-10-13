package com.base.demo_spring4.repository;

import com.base.demo_spring4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
