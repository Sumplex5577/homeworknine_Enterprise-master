package com.example.homeworknine.converters;

import com.example.homeworknine.dtos.PersonDto;
import com.example.homeworknine.models.Person;

public class PersonConverter {

    public static PersonDto convertPersonToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPhoneNumber(person.getPhoneNumber());
        personDto.setCarts(person.getCarts());
        personDto.setUsername(person.getUsername());
        personDto.setPassword(person.getPassword());
        return personDto;
    }

    public static Person convertPersonDtoToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPhoneNumber(personDto.getPhoneNumber());
        person.setCarts(personDto.getCarts());
        person.setUsername(personDto.getUsername());
        person.setPassword(personDto.getPassword());
        return person;
    }
}
