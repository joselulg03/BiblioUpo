/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.HibernateUtil;
import modelo.Rol;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author josel
 */
public class RolDAO {
    Session session = null;
    
    public RolDAO(){
        
    }
    
    public Rol read(String dominio){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Rol where dominio = :dominio");
        q.setParameter("dominio", dominio);
        Rol r = (Rol) q.uniqueResult();
        tx.commit();
        return r;
    }
}
