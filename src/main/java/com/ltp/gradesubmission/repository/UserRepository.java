package com.ltp.gradesubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltp.gradesubmission.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	@Query(value = "SELECT u.id FROM users u WHERE u.username = :username", nativeQuery = true)
	Long findUserIdByUsername(@Param("username") String username);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM users u WHERE u.id = :userId", nativeQuery = true)
	void deleteUserById(@Param("userId") Long userId);


}