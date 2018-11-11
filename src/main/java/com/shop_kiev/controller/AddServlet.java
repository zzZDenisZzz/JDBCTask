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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            Product product = new Product(name, price);
            TableProducts.insertIntoTable(product);
            resp.sendRedirect("/list");
        } catch (Exception e) {
            try {
                req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
            } catch (Exception ex) {
                log.error("Error: " + ex.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Error:", e.getMessage());
        }
    }
}