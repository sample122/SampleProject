package com.apress.springpersistence.audiomanager.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import com.apress.springpersistence.audiomanager.domain.Person;
import com.apress.springpersistence.audiomanager.service.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitTest {

    Person person;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        person = Person.builder().id((long) 123).name("Test User").build();
        when(personRepository.count()).thenReturn((long) 1);
        when(personRepository.findOne((long) 123)).thenReturn(person);
    }

    @Test
    public void testMockPersonRetrieval() {
        Assert.assertEquals("Test User", personRepository.findOne((long) 123).getName());
    }

    @Test
    public void testThatMockRepositorySaveDoesNothing() {
        Assert.assertEquals(1, this.personRepository.count());
        Person bogusPerson = Person.builder().id((long) 987).name("Bogus Test User").build();
        personRepository.save(bogusPerson);
        Assert.assertNotEquals(2, this.personRepository.count());
    }

}
