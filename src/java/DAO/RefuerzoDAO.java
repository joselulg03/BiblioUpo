/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import modelo.Refuerzo;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Jose
 */
public class RefuerzoDAO {
    Session session = null;

    public RefuerzoDAO() {
    }
    
    public void create(Refuerzo r) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
    }
    
    public Refuerzo read(Integer id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Refuerzo where id = :id");
        q.setParameter("id", id);
        Refuerzo p = (Refuerzo) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    public void delete(Refuerzo r) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(r);
        tx.commit();
    }
    
    public List<Refuerzo> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Refuerzo");
        List<Refuerzo> lr = (List<Refuerzo>) q.list();
        tx.commit();
        return lr;
    }
}
