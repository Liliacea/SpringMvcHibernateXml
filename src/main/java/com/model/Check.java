package com.model;

import com.persistance.CRUDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Check {
    public static void main(String[] args) throws SQLException {
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        CRUDaoImpl cruDAO = (CRUDaoImpl) ctx.getBean("cruDAO");



       //   SessionFactory sessionFactory = HibernateRunner.getSessionFactory();
        // Session session = sessionFactory.openSession();

        Person person = new Person.Builder()

                .name("bbb")
                .age(25)
                .build();

      //  cruDAO.select();
      //  cruDAO.findById(12);
     //   cruDAO.insert(person);
    //com.model.Person person1 = cruDAO.findById(16);
    //person1.setAge(123);
    //cruDAO.update(person1);
        cruDAO.select();
        //cruDAO.findById(16);
        cruDAO.findByName("aaa");











  /*  for (Iterator iterator = products.iterator();iterator.hasNext();){
    Product product = (Product) iterator.next();
    System.out.println(product.toString());
}

   */


        }

    }


