package com.example.homeworknine.repositories;
import com.example.homeworknine.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findPersonByUsername(String username);

}
