package br.com.guilhermezaparoli;

import br.com.guilhermezaparoli.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        logger.info(
                "Finding all People!"
        );
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add((person));
        }
        return persons;
    }


    public Person findById(String id) {
        logger.info(
                "Finding one Person!"
        );



        return mockPerson(1);

    };


    public Person create(Person person) {
        logger.info(
                "Create one Person!"
        );
        return person;
    }

    public Person update(Person person, String id) {
        logger.info(
                "updating one Person!"
        );
        return person;
    }

    public Void delete(String id) {
        logger.info(
                "Deleting one Person!"
        );

        return null;
    };




    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname" + i);
        person.setLastName("Lastname" + i);
        person.setAddress("Address in Brazil");
        person.setGender("Male");

        return person;
    }

}
