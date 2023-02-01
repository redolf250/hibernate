package com.redolf;

import com.redolf.model.Parent;
import com.redolf.model.Student;


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

import static com.redolf.config.HibernateUtils.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction=session.beginTransaction();
         Parent parent = Parent.builder()
                 .firstName("Ama")
                 .lastName("Rita")
                 .build();
         Student student = Student.builder()
                 .student_reference(UUID.randomUUID().toString())
                 .firstName("Asamaning")
                 .lastName("Anack")
                 .parent(parent)
                 .build();
         session.persist(student);
         Query query = session.createQuery("from Student",Student.class);
    
         List students = query.list();
         for (Object student1 : students){
             System.out.println(student1.toString());
            
         }
        transaction.commit();
    }
}
