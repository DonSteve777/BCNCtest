package com.bcnc.prueba.application.adapater;

import java.sql.Date;

import com.bcnc.prueba.application.port.ProductInteractionPort;
import com.bcnc.prueba.application.port.ProductPort;
import com.bcnc.prueba.domain.model.Product;

public class ProductInteractionAdapter implements ProductInteractionPort {

    private final ProductPort port;

    public ProductInteractionAdapter(ProductPort port) {
        this.port = port;
    }
    
    @Override
    public Product getProduct(Date startDate, Date endDate, Long brandId, Long productId) {
        return port.getProduct(startDate, endDate, brandId, productId);
    }

}
