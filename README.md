# Java CRUD Applications - Student & Product Management Systems

This repository contains two modular Java-based CRUD systems built using **Hibernate ORM**:
- 🎓 **WEB II Hibernate Pratical**
- 📦 **WEB II Hibernate**

Both applications showcase layered architectures with clean separation of concerns via Controller, Service, Entity, and DTO classes.

---

## 📁 WEB II Hibernate Pratical

### Features:
- Manage Students, Teachers, Classes & Subjects
- Assign Students to Subjects and Classes
- Hibernate-based persistence
- Organized MVC-style folder structure

### Structure:
WEB II Hibernate Pratical

    controller/
       StudentController.java
    dto/
       StudentDTO.java
    entity/
        Student.java
        Teacher.java
        Subject.java
        StuClass.java
        StudentHasSubject.java
    service/
        StudentService.java
        StudentClassService.java
    hibernate/
        HibernateUtil.java
    hibernate.cfg.xml

---

## 📁 WEB II Hibernate

### Features:
- CRUD operations for Products & Brands
- Basic to Advanced search functionality
- Hibernate ORM integration

### Structure:
WEB II Hibernate

    controller/
        insert.java
        DataUpdate.java
        DataDelete.java
        DataSearch.java
        DataSearch2.java
        DataSearch3.java
        DataSearch4.java
        DataAdvancedSearch.java
    hibernate/
        HibernateUtil.java
        Product.java
        Brand.java
    hibernate.cfg.xml
    
---

## 🛠️ Technologies Used
- Java SE  
- Hibernate ORM  
- MySQL  
- JDBC  
- Object-Oriented Programming

---



