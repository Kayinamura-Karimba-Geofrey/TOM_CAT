package com.example.controller;

import com.example.model.Student;
import com.example.services.StudentServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {

    private final StudentServices studentServices = StudentServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(req, resp);
                break;
            case "list":
            default:
                listStudents(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("insert".equals(action)) {
            insertStudent(req, resp);
        } else {
            listStudents(req, resp);
        }
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> listStudent = studentServices.getAllData();
        req.setAttribute("listStudent", listStudent);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("student-form.jsp").forward(req, resp);
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String school = req.getParameter("school");
        String dobStr = req.getParameter("dob");

        LocalDate dob = LocalDate.now();
        try {
            if (dobStr != null && !dobStr.isEmpty()) {
                dob = LocalDate.parse(dobStr);
            }
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        Student newStudent = new Student(name, email, school, dob);
        studentServices.addStudent(newStudent);
        resp.sendRedirect("students");
    }
}
