package com.shop_kiev.controller;

import com.shop_kiev.dao.TableProducts;
import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            Product product = new Product(name, price);
            TableProducts.insertIntoTable(product);
            response.sendRedirect("/list");
        } catch (Exception e) {
            try {
                request.getRequestDispatcher("jsp/add.jsp").forward(request, response);
            } catch (Exception ex) {
                log.error("Error: " + ex.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("jsp/add.jsp").forward(request, response);
        } catch (Exception e) {
            log.error("Error:", e.getMessage());
        }
    }
}
