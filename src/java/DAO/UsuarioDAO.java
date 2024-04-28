/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class UsuarioDAO {
    
    Session session = null;
    
    public UsuarioDAO(){
        
    }

    public Usuario read(String correo){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuario where correo = :correo");
        q.setParameter("correo", correo);
        Usuario u = (Usuario) q.uniqueResult();
        tx.commit();
        return u;
    }
    
    /*public void create(Cliente c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
    }
    
    public Cliente read(String dni){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Cliente where dni = :dni");
        q.setParameter("dni", dni);
        Cliente c = (Cliente) q.uniqueResult();
        tx.commit();
        return c;
    }
    
    public void update(Cliente c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
    }
    
    public void delete(Cliente c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
    }
    */
    public List<Usuario> list(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Usuario");
        List<Usuario> lu = (List<Usuario>) q.list();
        tx.commit();
        return lu;
    }
    
}
