/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Sala;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manuel
 */
public class SalaDAO {
    
    Session session = null;

    public SalaDAO() {
    }
    
    public void create(Sala s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }
    
    public Sala read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Sala where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Sala s = (Sala) q.uniqueResult();
        tx.commit();
        return s;
    }
    
    public void delete(Sala s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
    }
    
    public List<Sala> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Sala");
        List<Sala> ls = (List<Sala>) q.list();
        tx.commit();
        return ls;
    }
}
