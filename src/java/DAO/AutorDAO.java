/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.HibernateUtil;
import modelo.Autor;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class AutorDAO {
    Session session = null;
    
    public AutorDAO(){
        
    }
    
    public Autor read(String nombre){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Autor where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Autor a = (Autor) q.uniqueResult();
        tx.commit();
        return a;
    }
}
