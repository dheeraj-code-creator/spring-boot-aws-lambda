package com.example.aws.lambda.service;

import com.example.aws.lambda.domain.Order;
import com.example.aws.lambda.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class AwsLambdaService {

    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public Supplier<List<Order>> findAllOrders(){
        return  () -> orderRepository.preparOrder();
    }

    @Bean
    public Function<String, List<Order>> findOrderByName(){
       return (input)-> orderRepository.preparOrder()
                .stream()
                .filter(order->order.getName().equals(input)).collect(Collectors.toList());
    }
}
