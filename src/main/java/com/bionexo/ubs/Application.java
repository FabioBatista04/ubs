package com.bionexo.ubs;

import com.bionexo.contract.facade.UbsFacade;
import com.bionexo.contract.v1.UbsContract;
import com.bionexo.ubs.exception.ExceptionsHandle;
import com.bionexo.ubs.impl.UbsService;
import com.bionexo.ubs.impl.repository.UbsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {UbsContract.class, UbsFacade.class,UbsService.class,UbsRepository.class, ExceptionsHandle.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
