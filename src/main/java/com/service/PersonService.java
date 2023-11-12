package com.service;



import com.model.Person;

import java.util.List;

public interface PersonService {
  void addPerson (Person person);
  void savePerson(Person person);
  

  Person getPersonById(long id);


  Person deletePerson(Person person);
  

  
  List<Person> getAllPerson();
}
