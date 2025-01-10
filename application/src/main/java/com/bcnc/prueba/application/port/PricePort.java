
package com.bcnc.prueba.application.port;

import com.bcnc.prueba.domain.model.Price;
import java.sql.Date;

public interface PricePort {
    Price getPrice(Date startDate, Date endDate, Long brandId, Long PriceId);
}
