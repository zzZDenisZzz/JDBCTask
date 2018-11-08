package com.shop_kiev.controller;

import com.shop_kiev.dao.TableProducts;
import com.shop_kiev.model.Product;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = new Product(id);
            TableProducts.deleteFromTable(product);
            response.sendRedirect("/list");
        } catch (Exception e) {
            try {
                request.getRequestDispatcher("jsp/notfound.jsp").forward(request, response);
            } catch (Exception ex) {
                log.error("Not found");
            }
        }
    }
}
