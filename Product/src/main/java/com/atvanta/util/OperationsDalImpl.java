/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Levi
 */
public class OperationsDalImpl  implements OperationsDal{
     private static OperationsDal coreDal;

    private SessionFactory sessionFactory;

    private OperationsDalImpl(Databases database) {
        switch (database) {
            case PRODUCTS:
                sessionFactory = ProductUtil.getSessionFactory();
                break;
            default:
                break;
        }
    }

    public static OperationsDal getInstance(Databases database) {
        switch (database) {
            case PRODUCTS:
                if (coreDal == null) {
                    coreDal = new OperationsDalImpl(database);
                }
                return coreDal;
            default:
                return null;
        }
    }

    @Override
    public boolean saveOrUpdate(Object object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            /*if (session != null) {
                session.close();
            }*/
        }
    }

    @Override
    public Object save(Object object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Object newObject = session.save(object);
            transaction.commit();
            return newObject;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            /*if (session != null) {
                session.close();
            }*/
        }
    }

    @Override
    public boolean delete(Object object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            return true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            /*if (session != null) {
                session.close();
            }*/
        }
    }

    @Override
    public void executeQuery(CoreQuery query) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            OperationCommons.getSessionQuery(query, session).executeUpdate();
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*if (session != null) {
                session.close();
            }*/
        }
    }

    @Override
    public List fetch(CoreQuery query) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List result = OperationCommons.getSessionQuery(query, session).list();
            transaction.commit();
            return result;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            /*if (session != null) {
                if (!query.isLazyLoad()) {
                    session.close();
                }
            }*/
        }
    }

    public int getRecordCount(CoreQuery query) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            int count = ((Long) OperationCommons.getSessionQuery(query, session).uniqueResult()).intValue();
            transaction.commit();
            return count;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(OperationsDalImpl.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } finally {
            /*if (session != null) {
                if (!query.isLazyLoad()) {
                    session.close();
                }
            }*/
        }
    } 
}
