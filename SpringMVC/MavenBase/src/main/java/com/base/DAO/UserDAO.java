/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.User;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is for getting the user info from our database to use of spring security
 * @author Ohjelmistokehitys
 */
public class UserDAO {
   
    public static void addUser(User usr) throws Exception{
        
        //Create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //Beause we are writing to database we need transaction along with session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Save user info to db");
        
        session.save(usr); //Korvaa SQL -kielisen komennon: INSERT into teacher (na,e,email...) values ("joku","thth"...)
        
        //End transaction
        transaction.commit();  //Transactio tarkistaa, että tietokantaan tallennus onnistui. Jos ei, niin heittää poikkeuksen.
        //Release session. Kannattaa määrittää aina. Sulkeutuu myös automaattisesti joskus myöhemmin, jos ei määritetty. 
        session.close();
    }
    
    public static List<User> getUsers() throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        //use HQL query language here, NOT SQL
        Query query = session.createQuery("from User");    
        //Make the query  to database
        List<User> lst = query.list();
        session.close();
        //Return list of teachers
        return lst;
    }
    
    public static User findByUserName(String userName){
        
        List<User> lst = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        lst = session.createQuery("FROM User where username=?").
                setParameter(0, userName).list();
        
        if(!lst.isEmpty()){
            Hibernate.initialize(lst.get(0).getUserRoleses());
        }
        session.close();
        
        if(!lst.isEmpty()){
            return lst.get(0);
        }
        else{
            return null;
        }
    }
}

