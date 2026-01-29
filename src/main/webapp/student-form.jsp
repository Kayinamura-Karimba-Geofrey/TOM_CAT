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
            <div class="container" style="max-width: 600px;">
                <h1>
                    <c:if test="${student != null}">Edit Student</c:if>
                    <c:if test="${student == null}">New Student</c:if>
                </h1>
                <h2>Please provide student information below</h2>

                <form action="students?action=${student != null ? 'update' : 'insert'}" method="post">
                    <c:if test="${student != null}">
                        <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                    </c:if>

                    <div class="form-group">
                        <label>Full Name</label>
                        <input type="text" name="name" value="<c:out value='${student.name}' />" placeholder="John Doe"
                            required />
                    </div>

                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="email" name="email" value="<c:out value='${student.email}' />"
                            placeholder="john@example.com" required />
                    </div>

                    <div class="form-group">
                        <label>School / University</label>
                        <input type="text" name="school" value="<c:out value='${student.school}' />"
                            placeholder="Harvard University" />
                    </div>

                    <div class="form-group">
                        <label>Date of Birth</label>
                        <input type="date" name="dob" value="<c:out value='${student.dob}' />" />
                    </div>

                    <div style="display: flex; gap: 1rem; margin-top: 2rem;">
                        <button type="submit" class="btn btn-primary" style="flex: 2;">
                            Save Student
                        </button>
                        <a href="students" class="btn btn-danger" style="flex: 1;">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </body>

        </html>