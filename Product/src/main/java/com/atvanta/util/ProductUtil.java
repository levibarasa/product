/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import org.hibernate.Hibernate;
import org.hibernate.Session;  
import static org.hibernate.cfg.AvailableSettings.URL;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Levi
 */
public class ProductUtil {

  private static SessionFactory sessionFactory;
private static final String CONFIG_FILE = "prods.cfg.xml";

private ProductUtil() { 
}

static { 
    Configuration cfg = new AnnotationConfiguration().configure(ProductUtil.class.getClassLoader().getResource(CONFIG_FILE));
    sessionFactory = cfg.buildSessionFactory();
}
 
public static SessionFactory getSessionFactory() {
    return sessionFactory;
} 
public static Session getSession() throws HibernateException {
    return ProductUtil.sessionFactory.openSession();
}
 
public void shutdown() {
    ProductUtil.sessionFactory.getCurrentSession().close();
    ProductUtil.sessionFactory.close();
}
}
