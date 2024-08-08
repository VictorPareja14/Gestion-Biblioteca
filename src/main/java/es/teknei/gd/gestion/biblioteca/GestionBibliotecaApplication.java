package es.teknei.gd.gestion.biblioteca;

import es.teknei.gd.gestion.biblioteca.initializer.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionBibliotecaApplication implements CommandLineRunner {
	@Autowired
	Init init;
	public static void main(String[] args) {
		SpringApplication.run(GestionBibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args){
		init.displayMenu();
	}
}
