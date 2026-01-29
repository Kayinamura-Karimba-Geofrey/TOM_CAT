package com.example.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.model.Student;
import com.example.Util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class StudentServices {

    private static final SessionFactory sf = HibernateUtil.getSessionFactory();
    private static final StudentServices instance = new StudentServices();

    public static StudentServices getInstance() {
        return instance;
    }

    private StudentServices() {
    }

    public void addStudent(Student student) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.persist(student); // or session.save(student);
            session.getTransaction().commit();
        }
    }


    public Student listStudent() {
        try (Session session = sf.openSession()) {
            return session.get(Student.class, 1);
        }
    }

    @Transactional
    public List<Student> getAllData() {
        try (Session session = sf.openSession()) {
            Query<Student> q = session.createQuery("from Student", Student.class);
            return q.getResultList();
        }
    }

    public List<Student> listStudents() {
        try (Session session = sf.openSession()) {
            List<Student> students =
                    session.createQuery("select s from Student s", Student.class)
                            .getResultList();
            Hibernate.initialize(students);
            return students;
        }
    }


    public List<Student> findAllStudents() {
        try (Session session = sf.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cq = cb.createQuery(Student.class);
            Root<Student> root = cq.from(Student.class);
            cq.select(root);

            Query<Student> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    public List<Student> getAll() {
        try (Session session = sf.openSession()) {
            Query<Student> q = session.createQuery("from Student", Student.class);
            return q.getResultList();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = sf.openSession()) {
            Student student = session.get(Student.class, id);
            Hibernate.initialize(student);
            return student;
        }
    }

    public void updateStudent(Student student) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
        }
    }

    public void deleteStudent(int id) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            session.getTransaction().commit();
        }
    }
}



