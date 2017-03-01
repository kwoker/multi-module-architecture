package com.keveon.architecture.mapper;

import com.keveon.architecture.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Keveon on 2017/2/28.
 * User mapper
 */
@Mapper
@Repository
public interface UserMapper {
	@Select("SELECT user_id id, user_name name, user_password password FROM m_user WHERE user_id = #{id}")
	User findById(Long id);
}