<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Student Management App</title>
        </head>

        <body>
            <center>
                <h1>Student Management</h1>
                <h2>
                    <c:if test="${student != null}">
                        Edit Student
                    </c:if>
                    <c:if test="${student == null}">
                        Add New Student
                    </c:if>
                </h2>
            </center>
            <div align="center">
                <c:if test="${student != null}">
                    <form action="students?action=update" method="post">
                </c:if>
                <c:if test="${student == null}">
                    <form action="students?action=insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <c:if test="${student != null}">
                        <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                    </c:if>
                    <tr>
                        <th>Name:</th>
                        <td><input type="text" name="name" size="45" value="<c:out value='${student.name}' />"
                                required />
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td><input type="text" name="email" size="45" value="<c:out value='${student.email}' />"
                                required />
                        </td>
                    </tr>
                    <tr>
                        <th>School:</th>
                        <td><input type="text" name="school" size="45" value="<c:out value='${student.school}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Date of Birth (YYYY-MM-DD):</th>
                        <td><input type="date" name="dob" size="15" value="<c:out value='${student.dob}' />" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
        </body>

        </html>