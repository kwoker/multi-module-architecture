package com.keveon.architecture.service;

import com.keveon.architecture.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/3/1.
 * User service tests
 */
@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findById() throws Exception {
		User user = service.findById(1L);
		assertThat(user, notNullValue());
		assertThat(user.getId(), equalTo(1L));
	}

	@Test
	public void findByNameLike() throws Exception {
		Page<User> userPage = service.findByNameLike("user", new PageRequest(0, 10));
		assertThat(userPage.getContent().size(), greaterThanOrEqualTo(1));
	}

}