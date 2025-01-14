package com.bcnc.prueba.infrastructure.price.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import com.bcnc.prueba.domain.model.Price;
import com.fasterxml.jackson.annotation.JsonFormat;


// identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

public record PriceResponse (
    Long productId, 
    Long brandId, 
    int priceList,  
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss", timezone = "Europe/Madrid")
    Timestamp startDate, 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss", timezone = "Europe/Madrid")
    Timestamp endDate, 
    BigDecimal price
) {

    public static PriceResponse toResponse(Price price) {
        return new PriceResponse(price.productId(), price.brandId(), price.priceList(), price.startDate(), price.endDate(),  price.price());
    }

    @Override
    public String toString() {
        return "PriceResponse [productId=" + productId + ", brandId=" + brandId + ", priceList=" + priceList + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PriceResponse that = (PriceResponse) obj;
        return Objects.equals(productId, that.productId) && Objects.equals(brandId, that.brandId) && Objects.equals(priceList, that.priceList) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(price, that.price);
    }
}
