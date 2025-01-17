package com.bcnc.prueba.infrastructure.price.exception;

import java.sql.Timestamp;


public class PriceNotFoundException extends RuntimeException {

    private final Timestamp applicationDate;
    private final Long productId;
    private final Long brandId;

    public PriceNotFoundException(Timestamp applicationDate, Long productId, Long brandId) {
        super("Price not found for applicationDate: " + applicationDate + ", productId: " + productId + ", brandId: " + brandId);
        this.applicationDate = applicationDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }   


}
