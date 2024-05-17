/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Portatil;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose
 */
public class PortatilDAO {
    
    Session session = null;

    public PortatilDAO() {
    }
    
    public void create(Portatil p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }
    
    public Portatil read(String numSerie) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Portatil where numSerie = :numSerie");
        q.setParameter("numSerie", numSerie);
        Portatil p = (Portatil) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    public void delete(Portatil p) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public List<Portatil> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Portatil");
        List<Portatil> lp = (List<Portatil>) q.list();
        tx.commit();
        return lp;
    }
}
