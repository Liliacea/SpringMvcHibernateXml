package com.persistance;

import com.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;
@Component
@Repository
public class CRUDaoImpl implements CRUDao<Person, Integer>{
SessionFactory sessionFactory;

    @Autowired
    public CRUDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CRUDaoImpl() {
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public <T> T tx(Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    @Override
    public Person insert(Person person) {
        return tx(session -> {
            session.save(person);
            return person;
        });
    }

    @Override
    public Person update(Person person) {
        return tx(session -> {
        session.update(person);
        return person;
        });
    }

    @Override
    public List<Person> select() {
        return tx(session -> {
           List<Person> personList = session.createQuery("from Person").list();
            for (Person person: personList) {
                System.out.println("имя - " + person.getName()+ "\t" + "лет - " + person.getAge());
            }
            return personList;
        });
    }

    @Override
    public Person findById(Integer id) {
        return tx(session -> {
            Person person = (Person)session.get(Person.class, id);
            System.out.println("Нумер - " + person.getId() + "\t" + "имя - " + person.getName()+ "\t" + "лет - " + person.getAge());
            return person;

        });
    }

    @Override
    public Person delete(Person person) {
        return tx(session -> {
            session.delete(person);
            return person;
        });
    }


    public List <Person> findByName(String name) {
        return tx(session -> {
            Query query = session.createQuery("from Person where name = :paramName");
            query.setParameter("paramName", name);
            List<Person> personList = query.list();

            for (Person person: personList) {
                System.out.println("имя - " + person.getName()+ "\t" + "лет - " + person.getAge());
            }
            return personList;
    });
    }


}
