package com.bcnc.prueba.application.port;

import java.sql.Timestamp;
import com.bcnc.prueba.domain.model.Price;

public interface PriceInteractionPort {
    Price getPrice(Timestamp applicationDate, Long productId, Long brandId);
}
