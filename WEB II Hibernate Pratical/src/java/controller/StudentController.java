/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dto.StudentDTO;
import entity.Student;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import service.StudentClassService;
import service.StudentService;

/**
 *
 * @author Sanjana
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    StudentService ss = new StudentService();

    //search
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String action = request.getParameter("action");
        
        if (action.equals("getOne")) {
            
            getUserById(request, response);
            
        } else if (action.equals("getAll")) {
            
            getAllUsers(request, response);
            
        }
        
    }

    public void getUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int id = Integer.parseInt(request.getParameter("studentId"));
        
        Student student = ss.searchStudentById(id);
        
        Gson gson = new Gson();
        
        StudentDTO stu = new StudentDTO();
        
        stu.setId(student.getId());
        stu.setFirstName(student.getFirstName());        
        stu.setLastName(student.getLastName());
        stu.setEmail(student.getEmail());
        stu.setStudentClassId(student.getStuClass().getId());
        stu.setClassName(student.getStuClass().getName());
        
        String toJson = gson.toJson(stu);
        
        response.getWriter().print(toJson);
        
    }

  
    public void getAllUsers(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        Gson gson = new Gson();
        
        List<Student> allStudents = ss.allStudent();
        
        ArrayList<StudentDTO> stuList = new ArrayList();
        
        for (Student s : allStudents) {
            
            StudentDTO sd = new StudentDTO();
            sd.setId(s.getId());
            sd.setFirstName(s.getFirstName());
            sd.setLastName(s.getLastName());
            sd.setEmail(s.getEmail());
            sd.setStudentClassId(s.getStuClass().getId());
            sd.setClassName(s.getStuClass().getName());
            stuList.add(sd);
            
        }
        
        String toJson = gson.toJson(stuList);
        
        response.getWriter().print(toJson);
        
    }
    
//insert

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Gson gson = new Gson();

        Student student = gson.fromJson(request.getReader(), Student.class);

        ss.insertStudent(student);

        response.getWriter().write("Success");

    }

//update
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        StudentDTO studentdto = gson.fromJson(req.getReader(), StudentDTO.class);

        Student stu = new Student();
        
        stu.setId(studentdto.getId());        
        stu.setFirstName(studentdto.getFirstName());
        stu.setLastName(studentdto.getLastName());
        stu.setEmail(studentdto.getEmail());
        
        stu.setStuClass(new StudentClassService().getClassById(studentdto.getStudentClassId()));
        
        ss.updateStudent(stu);
        
    }

//delete
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
