package com.keveon.architecture.mapper;

import com.keveon.architecture.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


/**
 * Created by Keveon on 2017/3/1.
 * User mapper tests
 */
@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserMapperTest {
	@Autowired
	private UserMapper mapper;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void findById() throws Exception {
		User user = mapper.findById(1L);

		assertThat(user, notNullValue());
		assertThat(user.getId(), equalTo(1L));
	}

}