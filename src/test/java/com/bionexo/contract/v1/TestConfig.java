package com.bionexo.contract.v1;

import com.bionexo.contract.facade.UbsFacade;
import com.bionexo.contract.v1.UbsContract;
import com.bionexo.ubs.impl.UbsService;
import com.bionexo.ubs.impl.repository.UbsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public UbsRepository repository(UbsRepository repository){
        return repository;
    }
    @Bean
    public UbsService service(UbsRepository repository){
        return new UbsService(repository);
    }
    @Bean
    public UbsFacade facade(UbsService service){
        return new UbsFacade(service);
    }
    @Bean
    public UbsContract service(UbsFacade facade){
        return new UbsContract(facade);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
