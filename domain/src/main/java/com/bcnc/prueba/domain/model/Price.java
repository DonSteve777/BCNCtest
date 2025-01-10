package com.bcnc.prueba.domain.model;

import java.math.BigDecimal;
import java.sql.Date;

public record Price(
    Long brandId,
    Date startDate,
    Date endDate,
    int priceList,
    Long productId,
    int priority,
    BigDecimal price,
    String currency
) {}
