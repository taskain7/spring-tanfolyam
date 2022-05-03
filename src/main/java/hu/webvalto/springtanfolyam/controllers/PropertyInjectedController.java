package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@Qualifier("FooBar")
public class PropertyInjectedController {

    @Autowired
    @Qualifier("propertyGreetingServiceImpl")
    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
