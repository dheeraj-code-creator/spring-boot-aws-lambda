package com.example.aws.lambda.respository;

import com.example.aws.lambda.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderRepository {

    public List<Order> preparOrder(){
        List<Order> orderList = Arrays.asList(new Order(101, "Laptop", 15000, 1),
                                              new Order(102, "Computer", 25000, 2),
                                              new Order(103, "Computer", 35000, 3),
                                              new Order(104, "Mobile", 5000, 1));
        return orderList;
    }
}
