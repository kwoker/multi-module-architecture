package com.keveon.architecture.jdbc;

import com.keveon.architecture.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/3/1.
 * User dao tests
 */
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserDaoTest {

	@Autowired
	private UserDao dao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void create() throws Exception {
		User user = new User("好随意的名字", "random_password");
		assertThat(dao.create(user), equalTo(1));
	}

	@Test
	public void update() throws Exception {
		User user = new User("圣达菲", "abc123");
		user.setId(2L);
		assertThat(dao.update(user), equalTo(1));
	}

	@Test
	public void update2() throws Exception {
		User user = new User("凤港河", "def456");
		user.setId(3L);
		assertThat(dao.update2(user), equalTo(1));
	}
}