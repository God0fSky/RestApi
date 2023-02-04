package com.example.restapi.servlet;

import com.example.restapi.dtos.OrderDto;
import com.example.restapi.services.StoreService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class CustomServlet extends HttpServlet {

    private final StoreService storeService;

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CustomServlet doGet() method is invoked");
        resp.setContentType("text/plain");
        resp.setStatus(200);
        List<OrderDto> orderDtoList = storeService.getAll();
        resp.getWriter().println(orderDtoList.toString());
        resp.getWriter().close();
    }
    
}
