package com.klef.jfsd.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public void updateDepartment(int deptId, String newName, String newLocation) {
        // Load Hibernate Configuration
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // HQL Update Query
            String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE deptId = ?3";
            Query query = session.createQuery(hql);
            query.setParameter(1, newName);
            query.setParameter(2, newLocation);
            query.setParameter(3, deptId);

            // Execute Update
            int result = query.executeUpdate();
            System.out.println("Records updated: " + result);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void main(String[] args) {
        ClientDemo demo = new ClientDemo();
        demo.updateDepartment(1, "Updated Name", "Updated Location");
    }
}
