package br.com.guilhermezaparoli.repository;

import br.com.guilhermezaparoli.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
