package com.bcnc.prueba.application.port;

import java.sql.Date;
import com.bcnc.prueba.domain.model.Price;

public interface PriceInteractionPort {
    Price getPrice(Date startDate, Date endDate, Long brandId, Long PriceId);
}
