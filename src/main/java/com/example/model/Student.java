package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a student in the school system.
 * This class is mapped to a database table using JPA annotations.
 * It includes basic information like name, email, school, date of birth, and age.
 *
 * <p>The age is automatically calculated based on the date of birth.</p>
 *
 * @author geofrey
 */
@Entity
public class Student {

    /**
     * Unique identifier for the student. Auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Full name of the student (first and last name).
     */
    @Column(name = "fName", nullable = false, length = 100)
    private String name;

    /**
     * Email address of the student. Must be unique and not null.
     */
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    /**
     * Name of the school the student attends.
     */
    private String school;

    /**
     * Date of birth of the student.
     */
    private LocalDate dob;

    /**
     * Age of the student, automatically calculated from the date of birth.
     */
    @Column(name = "age", nullable = false)
    private int age;

    /**
     * Default no-argument constructor required by JPA.
     */
    public Student() {
    }

    /**
     * Constructs a new Student with the specified details.
     * Automatically calculates the age if the date of birth is provided.
     *
     * @param name   the full name of the student
     * @param email  the email address of the student
     * @param school the name of the school
     * @param dob    the date of birth of the student
     */
    public Student(String name, String email, String school, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.school = school;
        this.dob = dob;
        if (dob != null) {
            this.age = Period.between(dob, LocalDate.now()).getYears();
        }
    }

    /**
     * Returns the age of the student.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the ID of the student.
     *
     * @return the student ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     *
     * @param id the student ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the full name of the student.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the student.
     *
     * @param name the student's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the email of the student.
     *
     * @return the student's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the student.
     *
     * @param email the student's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the school name of the student.
     *
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * Sets the school name of the student.
     *
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * Returns the date of birth of the student.
     *
     * @return the date of birth
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the student and automatically updates the age.
     *
     * @param dob the date of birth to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
        if (dob != null) {
            this.age = Period.between(dob, LocalDate.now()).getYears();
        }
    }

    /**
     * Returns a string representation of the student, including all fields.
     *
     * @return string representation of the student
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}

