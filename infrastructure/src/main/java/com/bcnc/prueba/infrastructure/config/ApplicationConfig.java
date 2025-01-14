package com.bcnc.prueba.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import com.bcnc.prueba.infrastructure.price.persistence.adapter.PriceAdapter;
import com.bcnc.prueba.infrastructure.price.persistence.repository.PriceRepository;
import com.bcnc.prueba.infrastructure.price.persistence.repository.PriceRepositoryImpl;

import jakarta.inject.Singleton;

@Configuration
@ComponentScan(basePackages = {"com.bcnc.prueba.application", 
    "com.bcnc.prueba.infrastructure.price.persistence.repository" } // Asegúrate de incluir este paquete
    , includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Singleton.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class)
    }
)
public class ApplicationConfig {

    @Bean
    public PriceRepository priceRepository() {
        return new PriceRepositoryImpl();
    }

    @Bean
    public PriceAdapter priceAdapter(PriceRepository repository) {
        return new PriceAdapter(repository);
    }

}
