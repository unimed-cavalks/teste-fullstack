package unimed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unimed.model.entity.Beneficiario;
import unimed.model.repository.BeneficiarioRepository;


@SpringBootApplication
public class BeneficiariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiariosApplication.class, args);
    }
}
