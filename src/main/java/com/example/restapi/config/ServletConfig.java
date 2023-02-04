package com.example.restapi.config;

import com.example.restapi.services.StoreService;
import com.example.restapi.servlet.CustomServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Autowired
    private StoreService storeService;

    @Bean
    public ServletRegistrationBean customServletBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CustomServlet(storeService), "/restApi");
        return bean;
    }

}
