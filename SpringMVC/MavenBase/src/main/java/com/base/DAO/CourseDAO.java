/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Course;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ohjelmistokehitys
 */
public class CourseDAO {
    
    public static void addCourse(Course crs) throws Exception{
        
        //Create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //Beause we are writing to database we need transaction along with session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Save course info to db");
        session.save(crs); //Korvaa SQL -kielisen komennon: INSERT into teacher (na,e,email...) values ("joku","thth"...)
        
        //End transaction
        transaction.commit();  //Transactio tarkistaa, että tietokantaan tallennus onnistui. Jos ei, niin heittää poikkeuksen.
        //Release session. Kannattaa määrittää aina. Sulkeutuu myös automaattisesti joskus myöhemmin, jos ei määritetty. 
        session.close();
    }
    
    public static List<Course> getCourses() throws Exception{
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        //use HQL query language here, NOT SQL
        Query query = session.createQuery("from Course");    
        //Make the query  to database
        List<Course> lst = query.list();
        session.close();
        //Return list of teachers
        return lst;
    }
}
