//package com.example.services;
//
//import java.util.List;
//import java.time.LocalDate;
//
//import com.example.model.Student;
//import com.example.Util.HibernateUtil;
//
//public class Program {
//
//    public static void main(String[] args) {
//
//
//        HibernateUtil.getSessionFactory();
//
//        StudentServices service = StudentServices.getInstance();
//        System.out.println("Adding students...");
//
//        service.addStudent(
//                new Student("Alice", "alice@gmail.com", "RCA",
//                        LocalDate.of(2006, 5, 10))
//        );
//
//        service.addStudent(new Student("Bob", "bob@gmail.com", "RCA",
//                        LocalDate.of(2005, 2, 20)));
//
//        service.addStudent(new Student("Chris", "chris@gmail.com", "KICS",
//                        LocalDate.of(2004, 11, 5)));
//
//        System.out.println("Students added successfully.");
//
//
//        System.out.println("\nFetching all students (HQL)...");
//        List<Student> allStudents = service.getAll();
//        allStudents.forEach(System.out::println);
//
//
//        System.out.println("\nFetching student with ID = 1...");
//        Student s1 = service.getStudentById(1);
//        System.out.println(s1 != null ? s1 : "Student not found");
//
//
//        System.out.println("\nFetching all students using Criteria API...");
//        List<Student> critStudents = service.findAllStudents();
//        critStudents.forEach(System.out::println);
//
//
//        System.out.println("\nListStudents()...");
//        List<Student> ls = service.listStudents();
//        ls.forEach(System.out::println);
//
//
//        HibernateUtil.getSessionFactory().close();
//
//        System.out.println("\nProgram finished.");
//    }
//}
