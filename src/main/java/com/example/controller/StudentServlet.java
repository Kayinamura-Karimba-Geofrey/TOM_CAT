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

/**
 * Servlet implementation class StudentServlet.
 * <p>
 * This servlet acts as the controller layer for managing students in the system.
 * It handles all HTTP requests related to student operations, including listing,
 * creating, updating, and deleting students.
 * </p>
 * <p>
 * URL pattern: /students
 * </p>
 * <p>
 * Supported actions via query parameter "action":
 * <ul>
 *   <li>list - display all students (default)</li>
 *   <li>new - show form to add a new student</li>
 *   <li>edit - show form to edit an existing student</li>
 *   <li>delete - delete a student by ID</li>
 * </ul>
 * </p>
 *
 * @author
 * @version 1.0
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {

    /**
     * Singleton service instance for student operations.
     */
    private final StudentServices studentServices = StudentServices.getInstance();

    /**
     * Handles HTTP GET requests.
     * <p>
     * Determines the "action" parameter and delegates to the appropriate method:
     * list, new, edit, delete.
     * </p>
     *
     * @param req  HttpServletRequest object containing client request
     * @param resp HttpServletResponse object for sending response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
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
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteStudent(req, resp);
                break;
            case "list":
            default:
                listStudents(req, resp);
                break;
        }
    }

    /**
     * Handles HTTP POST requests.
     * <p>
     * Determines the "action" parameter and delegates to the appropriate method:
     * insert, update, or list students.
     * </p>
     *
     * @param req  HttpServletRequest object containing client request
     * @param resp HttpServletResponse object for sending response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("insert".equals(action)) {
            insertStudent(req, resp);
        } else if ("update".equals(action)) {
            updateStudent(req, resp);
        } else {
            listStudents(req, resp);
        }
    }

    /**
     * Retrieves all students and forwards them to the JSP page for display.
     *
     * @param req  HttpServletRequest object
     * @param resp HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> listStudent = studentServices.getAllData();
        req.setAttribute("listStudent", listStudent);
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }

    /**
     * Forwards request to the student creation form JSP.
     *
     * @param req  HttpServletRequest object
     * @param resp HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("student-form.jsp").forward(req, resp);
    }

    /**
     * Retrieves an existing student by ID and forwards the data to the edit form JSP.
     *
     * @param req  HttpServletRequest object containing student ID parameter
     * @param resp HttpServletResponse object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student existingStudent = studentServices.getStudentById(id);
        req.setAttribute("student", existingStudent);
        req.getRequestDispatcher("student-form.jsp").forward(req, resp);
    }

    /**
     * Inserts a new student based on form parameters.
     *
     * @param req  HttpServletRequest object containing student data
     * @param resp HttpServletResponse object
     * @throws IOException if an I/O error occurs
     */
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

    /**
     * Updates an existing student based on form parameters.
     *
     * @param req  HttpServletRequest object containing student data
     * @param resp HttpServletResponse object
     * @throws IOException if an I/O error occurs
     */
    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
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

        Student student = new Student(name, email, school, dob);
        student.setId(id);
        studentServices.updateStudent(student);
        resp.sendRedirect("students");
    }

    /**
     * Deletes a student based on the provided ID parameter.
     *
     * @param req  HttpServletRequest object containing student ID
     * @param resp HttpServletResponse object
     * @throws IOException if an I/O error occurs
     */
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentServices.deleteStudent(id);
        resp.sendRedirect("students");
    }

}
