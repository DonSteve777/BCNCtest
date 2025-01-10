package com.bcnc.prueba.domain.model;

import java.math.BigDecimal;
import java.sql.Date;

public record Product(
    Long id,
    Long brand_id,
    Date startDate,
    Date endDate,
    int priority,
    BigDecimal price,
    String currency

) {}
