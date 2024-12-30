package io.github.roopan.rc.infra.security.user.service;

import java.util.List;

import io.github.roopan.rc.infra.security.user.model.User;

public interface RedditUserService 
{
	List<User> findAllUsers();
}
