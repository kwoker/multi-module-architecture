package com.keveon.architecture.service;

import com.keveon.architecture.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * Created by Keveon on 2017/2/28.
 * User service
 */
public interface UserService {
	/**
	 * 通过编号查询用户信息
	 *
	 * @param id 用户编号
	 * @return 用户信息
	 */
	User findById(Long id);

	/**
	 * 通过用户名关键字模糊查询用户信息
	 *
	 * @param nameKeyword 用户名
	 * @param pageable    分页请求
	 * @return 符合条件的信息
	 */
	Page<User> findByNameLike(@Param("name") String nameKeyword, Pageable pageable);
}
