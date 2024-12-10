package com.spring.rest.ums.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.ums.entity.User;
import com.spring.rest.ums.service.UserService;
import com.spring.rest.ums.util.ResponseStructure;

@RestController // it is combination of both the annotation @Controller & @ResponseBody
public class UserController {

	private final UserService userService;

	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@PostMapping("save-user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		user = userService.saveUser(user);
		//	return ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
	}

	@GetMapping("find-user")
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int id) 
	{
		User user = userService.findUser(id);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "User Found", user));
	}

	@DeleteMapping("delete-user")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id)
	{
		User user = userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "User Deleted", user));
	}

	@PutMapping("update-user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user)
	{
		user = userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponseStructure.create(HttpStatus.OK.value(), "User Updated", user));
	}

	@GetMapping("find-by-username")
	public ResponseEntity<ResponseStructure<User>> findUserByUsername(@RequestParam String username)
	{
		User user =	userService.findUserByUsername(username);
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "User Found", user));
	}
}