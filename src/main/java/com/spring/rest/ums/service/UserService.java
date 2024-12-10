package com.spring.rest.ums.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.spring.rest.ums.entity.User;
import com.spring.rest.ums.exception.UserNotFoundByIdException;
import com.spring.rest.ums.exception.UserNotFoundByUsernameException;
import com.spring.rest.ums.repository.UserRepository;

@Service
public class UserService  {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User findUser(int id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundByIdException("Failed to find the User"));
	}

	public User deleteUser(int id) {
		return	userRepository.findById(id).map(user -> 
		{ userRepository.delete(user);
		return user;
		}).orElseThrow(()-> new UserNotFoundByIdException("Failed to find the User"));	
	}

	public User updateUser(User user) {
		Optional<User> optional =  userRepository.findById(user.getId());
		if(optional.isPresent()) {
			return userRepository.save(user);
		}
		else {
			throw new UserNotFoundByIdException("Failed to find the User");
		} 
	}

	public User findUserByUsername(String username) {
		return userRepository.findUserByUserName(username)
				.orElseThrow(()-> new UserNotFoundByUsernameException("Failed to find the user by username"));

	}
}