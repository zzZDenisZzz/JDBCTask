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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = TableProducts.selectOne(id);
            if (product != null) {
                req.setAttribute("product", product);
                req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("jsp/notfound.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            log.error("Error product not found: ", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int price = Integer.parseInt(req.getParameter("price"));
            Product product = new Product(id, name, price);
            TableProducts.updateToTable(product);
            resp.sendRedirect("/list");
        } catch (Exception e) {
            log.error("Error: ", e.getMessage());
        }
    }
}