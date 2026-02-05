<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Student Management App</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;800&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <body>
        <nav class="navbar">
            <a href="index.jsp" class="navbar-brand">AppPortfolio</a>
            <div class="navbar-links">
                <a href="index.jsp" class="nav-link active">Home</a>
                <a href="students" class="nav-link">Students</a>
            </div>
        </nav>

        <div class="main-content">
            <div class="container" style="max-width: 600px; text-align: center;">
                <div style="margin-bottom: 3rem;">
                    <h1>Welcome</h1>
                    <h2>Student Management Dashboard</h2>
                </div>

                <div class="project-card" style="max-width: 400px; margin: 0 auto;">
                    <div class="card-image"
                        style="background-color: #3b82f6; display: flex; align-items: center; justify-content: center; color: white; font-size: 3rem;">
                        🎓
                    </div>
                    <div class="card-content">
                        <h3>Student Management</h3>
                        <p>A full CRUD application for managing student records, built with Java Servlets, JSP, and
                            Hibernate.</p>
                        <div class="card-footer">
                            <a href="students" class="btn btn-primary" style="width: 100%;">Open Dashboard</a>
                        </div>
                    </div>
                </div>

                <p style="margin-top: 4rem; color: var(--text-muted); font-size: 0.8rem;">
                    Built with modern Java & Hibernate technologies
                </p>
            </div>
        </div>
    </body>

    </html>