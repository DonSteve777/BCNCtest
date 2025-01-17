package com.bcnc.prueba.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import com.bcnc.prueba.infrastructure.price.persistence.adapter.PriceAdapter;
import com.bcnc.prueba.infrastructure.price.persistence.repository.PriceRepository;
import jakarta.inject.Singleton;

@Configuration
@ComponentScan(basePackages = {"com.bcnc.prueba.application"},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Singleton.class)
)
public class ApplicationConfig {}
