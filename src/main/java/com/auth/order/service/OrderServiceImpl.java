package com.auth.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String placeOrder(String product, Integer amount) {
        log.info(String.format("Initiating Payment of %s for %s",amount,product));
        String payment = restTemplate.getForObject("http://localhost:8081/payment/"+amount, String.class);
        log.info((payment));
        if(payment.equalsIgnoreCase("Payment successful")){
            return String.format("Order Place for %s of amount %s",product,amount);
        }

        return String.format("Order failed for %s of amount %s",product,amount);
    }
}
