package com.bcnc.prueba.infrastructure.price.rest.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

// Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.

public record PriceRequest(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss",  timezone = "Europe/Madrid")
    Timestamp applicationDate,
    Long productId,
    Long brandId
) {}