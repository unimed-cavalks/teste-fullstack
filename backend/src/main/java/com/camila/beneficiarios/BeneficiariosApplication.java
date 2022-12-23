package com.camila.beneficiarios;

import com.camila.beneficiarios.model.entity.Plano;
import com.camila.beneficiarios.model.repository.BeneficiarioRepository;
import com.camila.beneficiarios.model.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BeneficiariosApplication {

    @Bean
    public CommandLineRunner run( @Autowired PlanoRepository repository ) {
        return args -> {


            Plano plano = Plano.builder().nome( "BASICO" ).valor( "100,00" ).build();
            Plano basico1 = Plano.builder().nome( "BASICO I" ).valor( "150,00" ).build();
            Plano basico2 = Plano.builder().nome( "BASICO II" ).valor( "200,00" ).build();
            Plano intermendiario = Plano.builder().nome( "INTERMEDIARIO I" ).valor( "300,00" ).build();
            Plano intermendiario1 = Plano.builder().nome( "INTERMEDIARIO II" ).valor( "350,00" ).build();


        repository.save( plano );
        repository.save( basico1 );
        repository.save( basico2 );
        repository.save( intermendiario );
        repository.save( intermendiario1 );




        };
    }

    public static void main( String[] args ) {
        SpringApplication.run( BeneficiariosApplication.class, args );
    }
}
