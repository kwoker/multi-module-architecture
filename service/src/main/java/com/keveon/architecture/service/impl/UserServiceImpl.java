package com.keveon.architecture.service.impl;

import com.keveon.architecture.mapper.UserMapper;
import com.keveon.architecture.model.User;
import com.keveon.architecture.repository.UserRepository;
import com.keveon.architecture.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

/**
 * Created by Keveon on 2017/3/1.
 * User service implements
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	private final UserMapper mapper;

	@Override
	public User findById(Long id) {
		notNull(id, "用户ID不能为空！");
		return mapper.findById(id);
	}

	@Override
	public Page<User> findByNameLike(String nameKeyword, Pageable pageable) {
		hasText(nameKeyword, "请输入用户名关键字！");
		return repository.findByNameLike("%" + nameKeyword + "%", pageable);
	}
}
