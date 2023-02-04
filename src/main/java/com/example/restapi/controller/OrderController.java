package com.example.restapi.controller;

import com.example.restapi.dtos.OrderDto;
import com.example.restapi.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final StoreService storeService;

    @GetMapping("{id}")
    public OrderDto getById(@PathVariable Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException("Invalid id");
        }
        return storeService.getById(id);
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return storeService.getAll();
    }

}