package com.keveon.architecture;

import com.keveon.architecture.model.User;
import com.keveon.architecture.repository.UserRepository;
import lombok.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ApplicationTests {

	@NonNull
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init() {
		User user = new User("user1", "123456");
		repository.save(user);
		user = new User("user2", "456789");
		repository.save(user);
		user = new User("user3", "789123");
		repository.save(user);
		user = new User("user4", "123789");
		repository.save(user);
	}

	@Test
	public void contextLoads() {
	}
}
