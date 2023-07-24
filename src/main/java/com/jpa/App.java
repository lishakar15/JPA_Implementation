package com.jpa;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;


public class App {
    public static void main(String[] args) {
        System.out.println("App started");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");//pu is mentioned in
        // persistence.xml
        EntityManager entityManager=  entityManagerFactory.createEntityManager();
        Student s = (Student) entityManager.find(Student.class, 2);
        System.out.println(s.toString());
        EntityTransaction tx = entityManager.getTransaction();
        Student s1 = new Student(23,"Chennai","Rama");
	    tx.begin();
        entityManager.persist(s1);
        tx.commit();
        entityManager.close();

    }
}
