package com.keveon.architecture.repository;

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

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Keveon on 2017/3/1.
 * User repository tests
 */
@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findByNameLike() throws Exception {
		Page<User> userPage = repository.findByNameLike("%" + "user" + "%", new PageRequest(0, 10));
		assertThat(userPage.getContent().size(), greaterThanOrEqualTo(1));
	}

}