package com.contactsunny.poc.PojoEntityExtensionPOC;

import com.contactsunny.poc.PojoEntityExtensionPOC.eventListener.MongoDBBeforeSaveEventListener;
import com.contactsunny.poc.PojoEntityExtensionPOC.models.UserEntity;
import com.contactsunny.poc.PojoEntityExtensionPOC.repositories.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public MongoDBBeforeSaveEventListener mongoDBBeforeSaveEventListener() {
        return new MongoDBBeforeSaveEventListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        UserEntity userEntity = new UserEntity();
        userEntity.setCity("Bangalore");
        userEntity.setCountry("India");
        userEntity.setName("Sunny");

        userEntity = userRepository.save(userEntity);

        List<UserEntity> userList = userRepository.findAll();

        userList.forEach(user -> System.out.println(new Gson().toJson(user)));
    }
}
