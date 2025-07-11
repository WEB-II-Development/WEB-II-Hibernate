/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import hibernate.Brand;
import hibernate.HibernateUtil;
import hibernate.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sanjana
 */
@WebServlet(name = "DataSearch3", urlPatterns = {"/DataSearch3"})
public class DataSearch3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Criteria c = s.createCriteria(Product.class);
        List<Product> productList = c.list();

        for (Product product : productList) {

            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getUnit_price());
            System.out.println(product.getQty());

            System.out.println(product.getBrand().getId());
            System.out.println(product.getBrand().getName());

        }

    }

}
