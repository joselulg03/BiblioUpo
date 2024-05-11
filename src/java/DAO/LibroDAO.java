/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Libro;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class LibroDAO {
    Session session = null;

    public LibroDAO() {

    }

    public void create(Libro l) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(l);
        tx.commit();
    }

    public Libro read(Integer id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro where id = :id");
        q.setParameter("id", id);
        Libro u = (Libro) q.uniqueResult();
        tx.commit();
        return u;
    }

    public void delete(Libro l) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(l);
        tx.commit();
    }

    public List<Libro> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro");
        List<Libro> ll = (List<Libro>) q.list();
        tx.commit();
        return ll;
    }
}
