package com.elcoma.api;

import com.elcoma.api.domain.Loja;
import com.elcoma.api.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {
	@Autowired
	private LojaRepository lojaRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			/*Loja loja1 = new Loja(null, "cnpjExemplo","estiloExemplo", "nomeExemplo", "pontoExemplo" );
			lojaRepository.saveAll(Arrays.asList(loja1));*/
	}
}
