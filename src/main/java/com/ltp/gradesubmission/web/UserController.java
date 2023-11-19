package com.ltp.gradesubmission.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id).getUsername(), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public String deleteUser(Authentication authentication) {
		String username = authentication.getName();
		userService.deleteUserByUsername(username);

		return "User with ID " + username + " deleted successfully.";
	}

	@PostMapping("/register")
	public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
