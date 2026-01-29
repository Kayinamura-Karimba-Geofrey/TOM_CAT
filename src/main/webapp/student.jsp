<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Student Management App</title>
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;800&display=swap"
                rel="stylesheet">
            <link rel="stylesheet" type="text/css" href="css/style.css">
        </head>

        <body>
            <div class="container">
                <h1>Student Management</h1>
                <h2>Manage your students efficiently in one place</h2>

                <div class="nav-actions">
                    <a href="students?action=new" class="btn btn-primary">
                        <span>+</span> Add New Student
                    </a>
                </div>

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>School</th>
                            <th>Birthday</th>
                            <th>Age</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${listStudent}">
                            <tr>
                                <td style="font-family: monospace; color: var(--text-secondary);">#
                                    <c:out value="${student.id}" />
                                </td>
                                <td style="font-weight: 600;">
                                    <c:out value="${student.name}" />
                                </td>
                                <td>
                                    <c:out value="${student.email}" />
                                </td>
                                <td>
                                    <c:out value="${student.school}" />
                                </td>
                                <td>
                                    <c:out value="${student.dob}" />
                                </td>
                                <td>
                                    <span
                                        style="background: rgba(99, 102, 241, 0.1); color: var(--primary-color); padding: 0.25rem 0.75rem; border-radius: 99px; font-size: 0.8rem; font-weight: 600;">
                                        <c:out value="${student.age}" /> yrs
                                    </span>
                                </td>
                                <td class="actions">
                                    <a href="students?action=edit&id=<c:out value='${student.id}'/>"
                                        class="btn btn-sm btn-primary">Edit</a>
                                    <a href="students?action=delete&id=<c:out value='${student.id}'/>"
                                        class="btn btn-sm btn-danger"
                                        onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>