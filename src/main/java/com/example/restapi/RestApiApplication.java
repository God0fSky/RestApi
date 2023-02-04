package com.example.restapi;

import com.example.restapi.dtos.OrderDto;
import com.example.restapi.dtos.ProductDto;
import com.example.restapi.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestApiApplication extends SpringBootServletInitializer {

    @Autowired
    private StoreService storeService;

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        /*List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto("Banana", BigDecimal.valueOf(25)));
        productDtoList.add(new ProductDto("Apple", BigDecimal.valueOf(15)));
        var dto = new OrderDto(null, LocalDate.now(), BigDecimal.valueOf(40), productDtoList);
        storeService.addOrder(dto);

        storeService.addProductInOrder(dto.getId(), "Banana", BigDecimal.valueOf(25));
        storeService.addProductInOrder(dto.getId(), "Apple", BigDecimal.valueOf(15));*/

    }



}
