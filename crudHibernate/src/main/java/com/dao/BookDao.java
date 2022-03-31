package com.dao;

import com.bean.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {
    static Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    public static int insertBook(Book b){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        int i=(int) session.save(b);
        if(i>0){
            transaction.commit();
            System.out.println("Record added successfully");
        }
        else
            System.out.println("Try Again!!!!");
        return i;
    }
    public static int updateBook(String bn,float p){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Query q= session.createQuery("update Book SET price=: x where bname=:y ");
        q.setParameter("x",p);
        q.setParameter("y",bn);
        int i=q.executeUpdate();
        transaction.commit();
        return i;
    }
    public static int deleteBook(String bn){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        Query q= session.createQuery("delete from Book where bname=:y");
        q.setParameter("y",bn);
        int i=q.executeUpdate();
        transaction.commit();
        return i;
    }
    public static List<Book> fetchBooks(){
        Session session=configuration.buildSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Query q=session.createQuery("from Book");
        return q.list();
    }

}
