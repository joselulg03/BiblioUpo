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

    public Libro read(String isbn) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro where isbn = :isbn");
        q.setParameter("isbn", isbn);
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

    public Libro readTitulo(String filtro) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro where titulo = :filtro");
        q.setParameter("filtro", filtro);
        Libro u = (Libro) q.uniqueResult();
        tx.commit();
        return u;
    }
    
    public List<Libro> readAutor(int idAutor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro where id_autor = :idAutor");
        q.setParameter("idAutor", idAutor);
        List<Libro> u = (List<Libro>) q.list();
        tx.commit();
        return u;
    }
    
    public List<Libro> readEditorial(int idEditorial) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Libro where id_editorial = :idEditorial");
        q.setParameter("idEditorial", idEditorial);
        List<Libro> u = (List<Libro>) q.list();
        tx.commit();
        return u;
    }
}
