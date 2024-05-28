
package DAO;

import java.util.List;
import modelo.Editorial;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class EditorialDAO {
    Session session = null;

    public EditorialDAO() {

    }

    public void create(Editorial a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    public Editorial read(String nombre) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Editorial where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Editorial a = (Editorial) q.uniqueResult();
        tx.commit();
        return a;
    }

    public void delete(Editorial a) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(a);
        tx.commit();
    }

    public List<Editorial> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Editorial");
        List<Editorial> la = (List<Editorial>) q.list();
        tx.commit();
        return la;
    }
}
