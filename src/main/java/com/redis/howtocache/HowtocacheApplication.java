package com.redis.howtocache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackages = "com.redis.howtocache")
public class HowtocacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowtocacheApplication.class, args);
	}

}
