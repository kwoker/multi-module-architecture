package com.keveon.architecture.jdbc;

import com.keveon.architecture.jdbc.tools.AppendSql;
import com.keveon.architecture.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Keveon on 2017/3/1.
 * User dao
 */
@Slf4j
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDao {
	private final JdbcTemplate jdbcTemplate;

	/**
	 * 新增用户信息
	 *
	 * @param user 用户
	 */
	public Integer create(User user) {
		return jdbcTemplate.update("INSERT INTO m_user(user_name, user_password) VALUES(?, ?)", user.getName(), user.getPassword());
	}

	/**
	 * 修改用户信息
	 *
	 * @param user 信息
	 */
	public Integer update(User user) {
		Map<String, Object> sqlAndParams = AppendSql.appendSql(user);

		String sql = sqlAndParams.get("sql").toString();
		log.info("sql = {}", sql);

		Object[] params = (Object[]) sqlAndParams.get("params");
		log.info("params = {}", Arrays.toString(params));

		return jdbcTemplate.update(sql, params);
	}

	/**
	 * 修改用户信息
	 *
	 * @param user 信息
	 */
	public Integer update2(User user) {
		Map<String, Object> sqlAndParams = AppendSql.appendSql(user, true);
		log.info("sqlAndParams.get(\"sql\") = {}", sqlAndParams.get("sql"));
		return jdbcTemplate.update(sqlAndParams.get("sql").toString());
	}
}