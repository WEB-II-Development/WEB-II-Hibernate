/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.StuClass;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentClassService {

    public StuClass getClassById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return (StuClass) session.load(StuClass.class, id);
    }
}
