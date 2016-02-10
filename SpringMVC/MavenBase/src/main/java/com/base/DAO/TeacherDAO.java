/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Teachers;
import com.base.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is for making GRUD operations to teacher table in our database
 * @author Ohjelmistokehitys
 */
public class TeacherDAO {
    
    /**
     * method adds new teacher into database
     * @param teach
     * @throws java.lang.Exception
     */
    public static void addTeacher(Teachers teach) throws Exception{
        
        //Create session to our database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        //Beause we are writing to database we need transaction along with session
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Save Teacher info to db");
        session.save(teach); //Korvaa SQL -kielisen komennon: INSERT into teacher (na,e,email...) values ("joku","thth"...)
        
        //End transaction
        transaction.commit();
        //Release session. Kannattaa määrittää aina. Sulkeutuu myös automaattisesti joskus myöhemmin, jos ei määritetty. 
        session.close();
    }
    
}
