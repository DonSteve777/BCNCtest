package com.bcnc.prueba.infrastructure.price.persistence.mapper;

import com.bcnc.prueba.domain.model.Price;
import com.bcnc.prueba.infrastructure.price.persistence.model.PriceEntity;

public class PriceMapper {

    public static Price toDomain(PriceEntity entity) {
        return new Price(entity.getBrandId(),  entity.getStartDate(), entity.getEndDate(), 
            entity.getPriceList(), entity.getProductId(), entity.getPriority(), entity.getPrice(), entity.getCurrency());
    }
    
}
