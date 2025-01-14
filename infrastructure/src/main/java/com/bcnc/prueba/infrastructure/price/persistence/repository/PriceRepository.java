package com.bcnc.prueba.infrastructure.price.persistence.repository;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.bcnc.prueba.infrastructure.price.persistence.model.PriceEntity;


@Repository
public interface PriceRepository {
        PriceEntity findPrice(Timestamp applicationDate, Long productId, Long brandId);
}