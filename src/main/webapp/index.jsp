<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Student Management App</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <body>
        <div class="container" style="max-width: 500px; text-align: center;">
            <h1>Welcome</h1>
            <h2>Student Management Dashboard</h2>

            <div style="margin-top: 2rem; display: flex; flex-direction: column; gap: 1rem;">
                <a href="students" class="btn btn-primary">
                    Go to Dashboard
                </a>
                <a href="hello-servlet" class="btn btn-danger">
                    Hello Servlet
                </a>
            </div>

            <p style="margin-top: 2rem; color: var(--text-secondary); font-size: 0.8rem;">
                Built with modern Java & Hibernate technologies
            </p>
        </div>
    </body>

    </html>