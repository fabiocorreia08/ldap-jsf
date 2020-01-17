package br.gov.cmb.jsf;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.gov.cmb.jsf.model.Person;
import br.gov.cmb.jsf.repo.PersonRepository;

@SpringBootApplication
public class Application {
	
	
	  private static Logger log = LoggerFactory.getLogger(Application.class);
	  
	  @Autowired private PersonRepository personRepository;
	 
	
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
	}	
	
	
	 @PostConstruct 
	 public void setup(){
		 log.info("Spring LDAP CRUD Operations Binding and Unbinding Example");

	        log.info("- - - - - - Managing persons");

	        List<Person> persons = personRepository.findAll();
	        log.info("persons: " + persons);
	        
	        List<Person> persons2 = personRepository.findByName("079855");
	        log.info("persons2: " + persons2);
	        
	        for (Person person : persons2) {
				if(person.getPhysicalDeliveryOfficeName().equals("079855")) {
					System.out.println("e iguallll");
				}else {
					System.out.println("não é igual");
				}
			}

	        Person john = personRepository.findOne("john");
	        john.setLastName("custom last name");
	        //personRepository.updateLastName(john);

	        Person jahn = personRepository.findOne("jahn");
	        jahn.setLastName("custom last name");
	        personRepository.update(jahn);

	        //Person person = new Person("uid", "new", "person");
	        //personRepository.create(person);

	        Person jihn = personRepository.findOne("jihn");
	        personRepository.delete(jihn);

	        persons = personRepository.findAll();
	        log.info("persons: " + persons);

	        

	        System.exit(-1);
	 }

}
