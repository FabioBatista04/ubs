package com.bionexo.ubs.impl.config;

import com.bionexo.ubs.impl.UbsProcessor;
import com.bionexo.ubs.impl.dto.UbsDTO;
import com.bionexo.ubs.impl.repository.model.Ubs;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final ClassPathResource resource = new ClassPathResource("ubs.csv");
    private final BeanWrapperFieldSetMapper<UbsDTO> fieldMapper = new BeanWrapperFieldSetMapper<>();
    private final String[] names = {"vlr_latitude", "vlr_longitude", "cod_munic", "cod_cnes", "nom_estab", "dsc_endereco",
            "dsc_bairro", "dsc_cidade", "dsc_telefone", "dsc_estrut_fisic_ambiencia", "dsc_adap_defic_fisic_idosos",
            "dsc_equipamentos", "dsc_medicamentos"};

    @Bean
    public FlatFileItemReader<UbsDTO> reader() {
        fieldMapper.setTargetType(UbsDTO.class);
        return new FlatFileItemReaderBuilder<UbsDTO>()
                .name("UbsItemReader")
                .resource(resource)
                .delimited()
                .names(names)
                .fieldSetMapper(fieldMapper)
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MongoItemWriter<Ubs> writer(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<Ubs>()
                .template(mongoTemplate)
                .collection("ubs")
                .build();
    }

    @Bean
    public Step step1(FlatFileItemReader<UbsDTO> itemReader, MongoItemWriter<Ubs> itemWriter, StepBuilderFactory stepBuilderFactory, UbsProcessor processor) {
        return stepBuilderFactory
                .get("step1")
                .<UbsDTO, Ubs>chunk(37690)
                .reader(itemReader)
                .processor(processor)
                .writer(itemWriter)
                .build();
    }

    @Bean
    public Job updateUbsJob(JobCompletionNotificationListener listener, Step step1, JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory
                .get("updateUbsJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1)
                .build();
    }
}
