package com.bcnc.prueba.infrastructure.price.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.prueba.application.port.PriceInteractionPort;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceRequest;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceResponse;

@RestController
@RequestMapping("Prices")
public class PriceController {

    private final PriceInteractionPort port;

    public PriceController(PriceInteractionPort port) {
        this.port = port;
    }

    @GetMapping()
    public PriceResponse getPrice(@RequestBody PriceRequest request) {
        var price = port.getPrice(request.applicationDate(), 
            request.productId(), request.brandId());
        return PriceResponse.toResponse(price);
    }

}
