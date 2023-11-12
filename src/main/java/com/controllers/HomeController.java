package com.controllers;

import com.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;


@Controller
public class HomeController {

  private PersonService personService;

  @Inject
  public HomeController(PersonService personService) {

    this.personService = personService;
  }
  
  @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
  public String showHomePage(Map<String, Object> model) {
    model.put("persons",
              personService.getAllPerson());
    return "home";
  }


}
