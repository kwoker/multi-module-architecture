package com.keveon.architecture;

import com.keveon.architecture.model.User;
import com.keveon.architecture.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class Application {

    @NonNull
    private final UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

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
}