package com.example.restapi.services;

import com.example.restapi.dtos.OrderDto;
import com.example.restapi.dtos.ProductDto;
import com.example.restapi.models.Order;
import com.example.restapi.models.Product;
import com.example.restapi.repositories.OrderRepository;
import com.example.restapi.repositories.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public OrderDto addOrder(OrderDto orderDto) {
        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        return productDto;
    }

    public ProductDto addProductInOrder(int orderId, String name, BigDecimal cost) {
        var productModel = new Product();
        productModel.setName(name);
        productModel.setCost(cost);
        Optional<Order> order = orderRepository.findById(orderId);
        productModel.setOrder(order.orElseThrow(
                () -> new EntityNotFoundException("User with id=" + orderId + " wasnt found"))
        );
        productRepository.save(productModel);
        return objectMapper.convertValue(productModel, ProductDto.class);
    }

    public List<OrderDto> getAll() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        return orders.stream()
                .map(item -> objectMapper.convertValue(item, OrderDto.class))
                .collect(Collectors.toList());
    }

    public OrderDto getById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return objectMapper.convertValue(order, OrderDto.class);
    }

}
