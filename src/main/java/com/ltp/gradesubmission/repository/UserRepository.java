package com.ltp.gradesubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltp.gradesubmission.entity.User;

import javax.swing.*;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	void deleteByUsername(String username);


}