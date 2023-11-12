package com.service;


import com.model.Person;
import com.persistance.CRUDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Math.min;

@Service("personService")
@Transactional(propagation=Propagation.REQUIRED)
public class PersonServiceImpl implements PersonService {




@Autowired
  CRUDao cruDao;



  @Override
  public void addPerson(Person person) {
    cruDao.insert(person);

  }

  @Override
  public void savePerson(Person person) {
cruDao.update(person);
  }

  @Override
  public Person getPersonById(long id) {
    return (Person) cruDao.findById(id);

  }

  @Override
  public Person deletePerson(Person person) {
    return (Person) cruDao.delete(person);
  }

  @Override
  public List<Person> getAllPerson() {
    return cruDao.select();
  }
}
