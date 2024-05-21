/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Ordenador;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Manuel
 */
public class OrdenadorDAO {
    
    Session session = null;

    public OrdenadorDAO() {
    }
    
    public void create(Ordenador o) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
    }
    
    public Ordenador read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Ordenador where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Ordenador o = (Ordenador) q.uniqueResult();
        tx.commit();
        return o;
    }
    
    public void delete(Ordenador o) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
    }
    
    public List<Ordenador> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Ordenador");
        List<Ordenador> lo = (List<Ordenador>) q.list();
        tx.commit();
        return lo;
    }
}
