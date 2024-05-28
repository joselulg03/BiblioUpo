/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
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

    public AutorDAO() {

    }

    public void create(Autor a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    public Autor read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Autor where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Autor a = (Autor) q.uniqueResult();
        tx.commit();
        return a;
    }
    
    public Autor readId(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Autor where id = :id");
        q.setParameter("id", id);
        Autor a = (Autor) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void delete(Autor a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    public List<Autor> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Autor");
        List<Autor> la = (List<Autor>) q.list();
        tx.commit();
        return la;
    }
}
