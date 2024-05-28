/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Categoria;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class CategoriaDAO {
    Session session = null;

    public CategoriaDAO() {

    }

    public void create(Categoria a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    public Categoria read(String id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Categoria where id = :id");
        q.setParameter("id", id);
        Categoria a = (Categoria) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void delete(Categoria a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    public List<Categoria> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Categoria");
        List<Categoria> la = (List<Categoria>) q.list();
        tx.commit();
        return la;
    }
}
