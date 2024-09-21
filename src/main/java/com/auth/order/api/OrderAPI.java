package com.auth.order.api;

import com.auth.order.dto.OrderDto;
import com.auth.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderAPI {

    @Autowired
    OrderService orderService;
    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto order){
        return new ResponseEntity<>(orderService.placeOrder(order.getProduct(),order.getAmount()), HttpStatus.CREATED);
    }
}
