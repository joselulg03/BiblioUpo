package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAO {

    Session session = null;

    public UsuarioDAO() {

    }

    public void create(Usuario u) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(u);
        tx.commit();
    }

    public Usuario readCorreo(String correo) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuario where correo = :correo");
        q.setParameter("correo", correo);
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }

    public Usuario readDni(String dni) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuario where dni = :dni");
        q.setParameter("dni", dni);
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }

    public void delete(Usuario u) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(u);
        tx.commit();
    }

    public List<Usuario> list() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuario");
        List<Usuario> lu = (List<Usuario>) q.list();
        tx.commit();
        return lu;
    }
    
    
}
