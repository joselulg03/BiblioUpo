/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Reserva;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class ReservaDAO {
    Session session = null;
    
    public ReservaDAO(){
        
    }
    
    public void create(Reserva r){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
    }
    
    public List<Reserva> list(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Reserva");
        List<Reserva> lr = (List<Reserva>) q.list();
        tx.commit();
        return lr;
    }
    
    /*public Reserva read(String nombre){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Autor where nombre = :nombre");
        q.setParameter("nombre", nombre);
        Autor a = (Autor) q.uniqueResult();
        tx.commit();
        return a;
    }*/
}
