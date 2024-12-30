package io.github.roopan.rc.infra.security.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.roopan.rc.infra.security.user.model.User;
import io.github.roopan.rc.infra.security.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RedditUserServiceImpl implements RedditUserService
{
	private final UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() 
	{
		return userRepository.findAll();
	}
}
