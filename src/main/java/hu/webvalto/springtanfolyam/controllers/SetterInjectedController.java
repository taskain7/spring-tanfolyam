package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        return greetingService.sayGreeting();
    }

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
