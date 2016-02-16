/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Students;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Method adds new student into database
 * @author Ohjelmistokehitys
 */
public class StudentDAO {
    
    public static void addStudent(Students student) throws Exception{
        
        //Create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //Beause we are writing to database we need transaction along with session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Save student info to db");
        session.save(student); //Korvaa SQL -kielisen komennon: INSERT into teacher (na,e,email...) values ("joku","thth"...)
        
        //End transaction
        transaction.commit();  //Transactio tarkistaa, että tietokantaan tallennus onnistui. Jos ei, niin heittää poikkeuksen.
        //Release session. Kannattaa määrittää aina. Sulkeutuu myös automaattisesti joskus myöhemmin, jos ei määritetty. 
        session.close();
    }
    
    public static List<Students> getStudents() throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        //use HQL query language here, NOT SQL
        Query query = session.createQuery("from Students");    
        //Make the query  to database
        List<Students> lst = query.list();
        session.close();
        //Return list of teachers
        return lst;
    }
}
