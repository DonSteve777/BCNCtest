package com.bcnc.prueba.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Objects;

public record Price(
    Long brandId,
    Timestamp startDate,
    Timestamp endDate,
    int priceList,
    Long productId,
    int priority,
    BigDecimal price,
    String currency
) {
    // 
       public Price {
        // Asegurar que el campo price tenga una escala fija de 2 decimales
        // si no la comparación me daba problemas en los test 
        price = price.setScale(2, RoundingMode.HALF_UP);
    }

}
