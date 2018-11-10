package com.shop_kiev.controller;

import com.shop_kiev.dao.TableProducts;
import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet("/update")
public class UpdateListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = TableProducts.selectOne(id);
            if (product != null) {
                request.setAttribute("product", product);
                request.getRequestDispatcher("jsp/update.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/notfound.jsp").forward(request, response);
            }
        } catch (Exception e) {
            log.error("Error product not found: ", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            Product product = new Product(id, name, price);
            TableProducts.updateToTable(product);
            response.sendRedirect("/list");
        } catch (Exception e) {
            log.error("Error: ", e.getMessage());
        }
    }
}
