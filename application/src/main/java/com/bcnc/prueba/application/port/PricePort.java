
package com.bcnc.prueba.application.port;

import com.bcnc.prueba.domain.model.Price;
import java.sql.Timestamp;

public interface PricePort {
    Price getPrice(Timestamp applicationDate, Long productId, Long brandId);
}
