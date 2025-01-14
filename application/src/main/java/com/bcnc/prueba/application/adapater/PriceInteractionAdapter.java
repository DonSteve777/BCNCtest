package com.bcnc.prueba.application.adapater;

import java.sql.Timestamp;

import com.bcnc.prueba.application.port.PriceInteractionPort;
import com.bcnc.prueba.application.port.PricePort;
import com.bcnc.prueba.domain.model.Price;

import jakarta.inject.Singleton;

// anotación de jakarta para no acoplar el framework spring.
// este componente no va a tener estado, así que puedo usar @Singleton
@Singleton
public class PriceInteractionAdapter implements PriceInteractionPort {

    private final PricePort port;

    public PriceInteractionAdapter(PricePort port) {
        this.port = port;
    }
    
    @Override
    public Price getPrice(Timestamp applicationDate, Long productId, Long brandId) {
            return port.getPrice(applicationDate, productId, brandId);
    }

}
