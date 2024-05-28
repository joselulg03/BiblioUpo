package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Idioma;
import org.hibernate.Query;
import org.hibernate.Session;

public class IdiomaDAO {
    Session session = null;

    public IdiomaDAO() {

    }

    public void create(Idioma a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    public Idioma read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Idioma where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Idioma a = (Idioma) q.uniqueResult();
        tx.commit();
        return a;
    }
    
    public Idioma readId(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Idioma where id = :id");
        q.setParameter("id", id);
        Idioma a = (Idioma) q.uniqueResult();
        tx.commit();
        return a;
    }


    public void delete(Idioma a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    public List<Idioma> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Idioma");
        List<Idioma> la = (List<Idioma>) q.list();
        tx.commit();
        return la;
    }
}
