package com.juliomachillanda.superheros;

import com.juliomachillanda.superheros.model.SuperHeros;
import com.juliomachillanda.superheros.repository.SuperherosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class SuperherosApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SuperherosApplication.class);
	@Autowired
	private SuperherosRepository superherosRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuperherosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<SuperHeros> superherosEntities = superherosRepository.findAll();
		for (SuperHeros superHero: superherosEntities)
		logger.info(String.valueOf(superHero));
	}
}
