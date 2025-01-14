package com.bcnc.prueba.infrastructure.price.persistence.adapter;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcnc.prueba.application.port.PricePort;
import com.bcnc.prueba.domain.model.Price;
import com.bcnc.prueba.infrastructure.price.exception.PriceNotFoundException;
import com.bcnc.prueba.infrastructure.price.persistence.mapper.PriceMapper;
import com.bcnc.prueba.infrastructure.price.persistence.model.PriceEntity;
import com.bcnc.prueba.infrastructure.price.persistence.repository.PriceRepository;

@Component
public class PriceAdapter implements PricePort {

    private final PriceRepository repository;

    @Autowired
    public PriceAdapter(PriceRepository repository) {
        this.repository = repository;
    }


    @Override
    public Price getPrice(Timestamp applicationDate, Long productId, Long brandId) {
        PriceEntity priceEntity = repository.findPrice(applicationDate, productId, brandId);
        if (priceEntity == null)
            throw new PriceNotFoundException(applicationDate, productId, brandId);
        return PriceMapper.toDomain(priceEntity);
    }

}
