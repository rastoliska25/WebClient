package com.example.WebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class WebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebClientApplication.class, args);
        System.out.println("test");

        List<Statue> statues = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
			Generator generator = new Generator();
			statues.add(new Statue(generator.socha, 1, generator.weight, generator.length, generator.width, generator.height));
        }

		statues.forEach(statue -> System.out.println(statue));


		Set<Statue> setStatues =
				statues.stream()
						.map(statue -> new Statue(
								statue.getName() + "set",
								statue.getTypeId(),
								statue.getWeight(),
								statue.getLength(),
								statue.getWidth(),
								statue.getHeight()
						))
						.collect(Collectors.toSet());

		System.out.println("\n");

		setStatues.forEach(statue -> System.out.println(statue));


    }

}
