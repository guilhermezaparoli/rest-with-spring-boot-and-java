package br.com.guilhermezaparoli.services;

import br.com.guilhermezaparoli.exception.ResourceNotFoundException;
import br.com.guilhermezaparoli.model.Person;
import br.com.guilhermezaparoli.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;



    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        logger.info(
                "Finding all People!"
        );
        return repository.findAll();
    }


    public Person findById(Long id) {
        logger.info(
                "Finding one Person!"
        );

        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

    };


    public Person create(Person person) {
        logger.info(
                "Create one Person!"
        );
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info(
                "updating one Person!"
        );
       Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public Void delete(Long id) {
        logger.info(
                "Deleting one Person!"
        );
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);

        return null;
    };


}
