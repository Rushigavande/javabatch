package com.luv2code.lms.repository;

import com.luv2code.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
