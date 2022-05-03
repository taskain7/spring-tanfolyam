package hu.webvalto.springtanfolyam;

import hu.webvalto.springtanfolyam.config.DatasourceProperties;
import hu.webvalto.springtanfolyam.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringTanfolyamApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringTanfolyamApplication.class, args);
		MyController myController = applicationContext.getBean(MyController.class);
		myController.sayHello();
		System.out.println("----------------DI-------------");

		PropertyInjectedController propertyInjectedController = applicationContext.getBean(PropertyInjectedController.class);
		System.out.println(propertyInjectedController.getGreeting());

		SetterInjectedController setterInjectedController = applicationContext.getBean(SetterInjectedController.class);
		System.out.println(setterInjectedController.getGreeting());

		ConstructorInjectedController constructorInjectedController = applicationContext.getBean(ConstructorInjectedController.class);
		System.out.println(constructorInjectedController.getGreeting());

		I18nController i18nController = applicationContext.getBean(I18nController.class);
		i18nController.sayGreeting();

		DatasourceProperties datasourceProperties = applicationContext.getBean(DatasourceProperties.class);
		System.out.println(datasourceProperties.getJdbcUrl());
	}

}
