/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.SistemaOperativo;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jose
 */
public class SistemaOperativoDAO {
    
    Session session = null;

    public SistemaOperativoDAO() {
    }
    
    
    public void create(SistemaOperativo a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    public SistemaOperativo read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from SistemaOperativo where nombre = :nombre");
        q.setParameter("nombre", nombre);
        SistemaOperativo a = (SistemaOperativo) q.uniqueResult();
        tx.commit();
        return a;
    }
    
    public SistemaOperativo readId(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from SistemaOperativo where id = :id");
        q.setParameter("id", id);
        SistemaOperativo a = (SistemaOperativo) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void delete(SistemaOperativo a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    public List<SistemaOperativo> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from SistemaOperativo");
        List<SistemaOperativo> la = (List<SistemaOperativo>) q.list();
        tx.commit();
        return la;
    }
    
}
