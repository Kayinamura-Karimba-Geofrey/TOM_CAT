<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Student Management App</title>
    </head>

    <body>
        <center>
            <h1>Student Management</h1>
            <h2>Add New Student</h2>
        </center>
        <div align="center">
            <form action="students?action=insert" method="post">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Name:</th>
                        <td><input type="text" name="name" size="45" required /></td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td><input type="text" name="email" size="45" required /></td>
                    </tr>
                    <tr>
                        <th>School:</th>
                        <td><input type="text" name="school" size="45" /></td>
                    </tr>
                    <tr>
                        <th>Date of Birth (YYYY-MM-DD):</th>
                        <td><input type="date" name="dob" size="15" /></td>
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