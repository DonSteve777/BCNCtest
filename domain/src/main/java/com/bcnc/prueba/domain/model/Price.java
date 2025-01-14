package com.bcnc.prueba.domain.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record Price(
    Long brandId,
    Timestamp startDate,
    Timestamp endDate,
    int priceList,
    Long productId,
    int priority,
    BigDecimal price,
    String currency
) {}
