package com.example.aws.lambda.service;

import com.example.aws.lambda.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class UserService {

    List<User> userList = Arrays.asList(new User("Jack", "111", 3000.0),
                                        new User("Tom", "222", 4000.0),
                                        new User("Lisa", "333", 5000.0));

    @Bean
    public Supplier<List<User>> getAllUserDetails(){
        return ()->userList;
    }

    @Bean
    public Function<String, List<User>> getUserDetailsByName(){
        return (inputEvent)->userList.stream()
                .filter(result->result.getUserName().equals(inputEvent)).collect(Collectors.toList());
    }
}
