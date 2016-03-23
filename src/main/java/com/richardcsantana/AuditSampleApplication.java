package com.richardcsantana;

import com.richardcsantana.model.Dado;
import com.richardcsantana.repository.DadoRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class AuditSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditSampleApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo (DadoRepository repository){
        return (args) -> {
            repository.save(new Dado("teste"));
            repository.save(new Dado("teste1"));
            repository.save(new Dado("teste2"));
            repository.save(new Dado("teste3"));
            log.info("Dados encontrados com findAll():");
            log.info("--------------------------------");
            for(Dado dado : repository.findAll()){
                log.info(dado.toString());
            }
            log.info("");
        };
    }
}
