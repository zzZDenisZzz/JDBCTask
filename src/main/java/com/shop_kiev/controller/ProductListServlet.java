package com.shop_kiev.controller;

import com.shop_kiev.dao.TableProducts;
import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@WebServlet("/list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            List<Product> products = TableProducts.selectFromTable();
            req.setAttribute("products", products); // Will be available as ${products} in JSP
            req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Error: ", e.getMessage());
        }
    }
}