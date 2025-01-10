package com.bcnc.prueba.application.port;

import java.sql.Date;
import com.bcnc.prueba.domain.model.Product;

public interface ProductInteractionPort {
    Product getProduct(Date startDate, Date endDate, Long brandId, Long productId);
}
