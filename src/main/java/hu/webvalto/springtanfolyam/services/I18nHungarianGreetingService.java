package hu.webvalto.springtanfolyam.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("HU")
@Service("i18nGreetingService")
public class I18nHungarianGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Világ!";
    }
}
