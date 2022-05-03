package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController testObj;

    @BeforeEach
    void setUp() {
        testObj = new PropertyInjectedController();
    }

    @Test
    void getGreeting() {
        System.out.println(testObj.getGreeting());
    }
}