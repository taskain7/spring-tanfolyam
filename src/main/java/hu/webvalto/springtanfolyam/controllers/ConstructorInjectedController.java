package hu.webvalto.springtanfolyam.controllers;

import hu.webvalto.springtanfolyam.services.GreetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ConstructorInjectedController {

    private final GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
