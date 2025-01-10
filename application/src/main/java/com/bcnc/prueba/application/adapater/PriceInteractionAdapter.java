package com.bcnc.prueba.application.adapater;

import java.sql.Date;

import com.bcnc.prueba.application.port.PriceInteractionPort;
import com.bcnc.prueba.application.port.PricePort;
import com.bcnc.prueba.domain.model.Price;

public class PriceInteractionAdapter implements PriceInteractionPort {

    private final PricePort port;

    public PriceInteractionAdapter(PricePort port) {
        this.port = port;
    }
    
    @Override
    public Price getPrice(Date startDate, Date endDate, Long brandId, Long PriceId) {
        return port.getPrice(startDate, endDate, brandId, PriceId);
    }

}
