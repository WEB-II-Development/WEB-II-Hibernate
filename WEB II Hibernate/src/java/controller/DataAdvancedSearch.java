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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sanjana
 */
@WebServlet(name = "DataAdvancedSearch", urlPatterns = {"/DataAdvancedSearch"})
public class DataAdvancedSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Criteria c = s.createCriteria(Product.class);

        //Restrictions
//        Criterion crt1 = Restrictions.eq("qty", 30); //("variable name",value) equal
//        c.add(crt1);

//        Criterion crt2 = Restrictions.lt("qty", 10); // lesthan
//        c.add(crt2);

//        Criterion crt1 = Restrictions.lt("price", 200000.0);
//        Criterion crt2 = Restrictions.like("name", "Ultra", MatchMode.END);
//        c.add(crt1);
//        c.add(crt2);

//        Criterion crt1 = Restrictions.lt("qty", 30);
//        Order o1 = Order.asc("qty");
//        
//        c.add(crt1);
//        c.addOrder(o1);

        Criterion crt1 = Restrictions.le("unit_price", 200000.0);
        c.add(crt1);

//        Brand b = (Brand) s.load(Brand.class, 1); // 1kiyana ide ekata anuwa brand search
//        Criterion crt2 = Restrictions.eq("brand", b);
//        c.add(crt2);

        Criteria c2 = s.createCriteria(Brand.class); //apple brand name product search 
        Criterion crt2 = Restrictions.eq("name", "Apple");
        c2.add(crt2);

//        Brand b = (Brand) c2.list().get(0);
        Brand b = (Brand) c2.uniqueResult(); // api shuwar ekatama dannawanama eaka result ekek enne kiyala meka use karanna puluwan

        Criterion crt3 = Restrictions.eq("brand", b);
        c.add(crt3);

        Order ol = Order.asc("unit_price");
        c.addOrder(ol);

        // Search All 
        List<Product> productList = c.list();
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }

}
