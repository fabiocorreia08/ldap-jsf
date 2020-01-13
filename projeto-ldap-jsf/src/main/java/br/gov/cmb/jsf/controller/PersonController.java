package br.gov.cmb.jsf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.gov.cmb.jsf.model.Person;
import br.gov.cmb.jsf.repo.PersonRepository;

@Controller
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("person_list");
		List<Person> personList = personRepository.findAll();
		model.addObject("personList", personList);		
		return model;
	}

	@RequestMapping(value="/update/{uid}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable String uid) {
		ModelAndView model = new ModelAndView("person_list");
		Person person = personRepository.findByUid(uid);
		model.addObject("personForm", person);
		model.setViewName("person_form");
		return model;		
	}	

}
