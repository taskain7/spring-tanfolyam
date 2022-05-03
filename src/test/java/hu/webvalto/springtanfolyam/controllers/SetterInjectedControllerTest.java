package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {

    SetterInjectedController testObj;

    @BeforeEach
    public void setUp() {
        testObj = new SetterInjectedController();
        testObj.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(testObj.getGreeting());
    }
}