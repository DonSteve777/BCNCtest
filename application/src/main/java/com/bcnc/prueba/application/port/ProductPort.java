
package com.bcnc.prueba.application.port;

import com.bcnc.prueba.domain.model.Product;
import java.sql.Date;

public interface ProductPort {
    Product getProduct(Date startDate, Date endDate, Long brandId, Long productId);
}
