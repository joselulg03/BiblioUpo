/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Recurso;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class RecursoDAO {
    Session session = null;
    
    public RecursoDAO(){
        
    }
    
    public void create(Recurso a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }
    
    public Recurso read(Integer id){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Recurso where id = :id");
        q.setParameter("id", id);
        Recurso a = (Recurso) q.uniqueResult();
        tx.commit();
        return a;
    }
}
