package hu.webvalto.springtanfolyam.client;

import hu.webvalto.springtanfolyam.dto.RecipeDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class RestClient {

    private final static String URL = "http://localhost:8080/api/recipe/";

    private final RestTemplate restTemplate;

    public RestClient() {
        this.restTemplate = new RestTemplate();
    }

    @PostConstruct
    public void callRestApi() {
        HttpHeaders httpHeaders = restTemplate.headForHeaders(URL);
        HttpEntity<RecipeDTO> request = new HttpEntity<>(new RecipeDTO());
        ResponseEntity<RecipeDTO> response = restTemplate.getForEntity(URL + 1, RecipeDTO.class);
        System.out.println("--------------------------");
        System.out.println(response);
        System.out.println("--------------------------");
    }
}
