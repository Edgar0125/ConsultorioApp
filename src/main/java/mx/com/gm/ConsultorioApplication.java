package mx.com.gm;

import mx.com.gm.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = {"mx.com.gm"})
//@SpringBootApplication
//@ComponentScan( basePackages = {"com.*"} )
//@Configuration
//

//@EnableJpaRepositories( basePackages = {"mx.com.gm.repository"} )
@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}
@Autowired
private CitaService citaService;
	@Override
	public void run(String... args) throws Exception {
		citaService.registrarCita("Primera cita");
	}
}
