package com.juliomachillanda.superheros;

import com.juliomachillanda.superheros.model.SuperherosEntity;
import com.juliomachillanda.superheros.repository.SuperherosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class SuperherosApplication implements CommandLineRunner {

	@Autowired
	private SuperherosRepository superherosRepository;

	public static void main(String[] args) {
		SpringApplication.run(SuperherosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<SuperherosEntity> superherosEntities = superherosRepository.findAll();
		superherosEntities.forEach(System.out::println);
	}
}
