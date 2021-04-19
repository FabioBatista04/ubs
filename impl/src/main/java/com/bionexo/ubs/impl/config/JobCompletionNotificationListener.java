package com.bionexo.ubs.impl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            try {
                Files.createDirectories(Path.of("outputfile/"));
                Files.move(Path.of("impl/src/main/resources/ubs.csv"), Path.of("outputfile/ubs.csv"), StandardCopyOption.ATOMIC_MOVE);

            } catch (Exception e) {
                log.info("Arquivo Não Encontrado");
            }
            log.info("Processo de leitura de arquivo finalizado");


        }
    }
}