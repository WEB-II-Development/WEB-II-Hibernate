/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Student;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Sanjana
 */
public class StudentService {

    private final SessionFactory sessionFactory;
    private final Session session;

    public StudentService() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void insertStudent(Student s) {

        session.save(s);
        session.beginTransaction().commit();

    }

    public void updateStudent(Student s) {

        session.update(s);
        session.beginTransaction().commit();

    }

    public void deleteStudent(Student s) {

        session.delete(s);
        session.beginTransaction().commit();

    }

    public Student searchStudentById(int id) {

        return (Student) session.load(Student.class, id);

    }

    public List<Student> allStudent() {

        return null;

    }

}
