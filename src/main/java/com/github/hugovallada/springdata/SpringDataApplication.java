package com.github.hugovallada.springdata;

import com.github.hugovallada.springdata.entities.Cargo;
import com.github.hugovallada.springdata.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SpringDataApplication implements CommandLineRunner {


	private final CargoRepository cargoRepository;

	@Autowired
	public SpringDataApplication(CargoRepository cargoRepository){
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor de Software");

		//cargoRepository.save(cargo);
	}
}
