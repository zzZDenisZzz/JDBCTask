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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = new Product(id);
            TableProducts.deleteFromTable(product);
            resp.sendRedirect("/list");
        } catch (Exception e) {
            try {
                req.getRequestDispatcher("jsp/notfound.jsp").forward(req, resp);
            } catch (Exception ex) {
                log.error("Not found");
            }
        }
    }
}