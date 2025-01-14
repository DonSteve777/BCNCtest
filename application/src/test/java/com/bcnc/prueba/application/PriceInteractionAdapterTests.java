package com.bcnc.prueba.application;

import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

import com.bcnc.prueba.application.adapater.PriceInteractionAdapter;
import com.bcnc.prueba.application.port.PricePort;
import com.bcnc.prueba.domain.model.Price;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PriceInteractionAdapterTests {

	private final PricePort pricePort = mock(PricePort.class);
	//system under test
    private final PriceInteractionAdapter sut = new PriceInteractionAdapter(pricePort);

	// @Test
    // void get_whenInvoke_thenCallGetFromPricePort() {
	// 	var startDate = Date.valueOf(LocalDate.of(2025, 1, 1));
	// 	var endDate = Date.valueOf(LocalDate.of(2025, 2, 1));
	// 	var productId = 1L;
	// 	var brandId = 1L;
    //     sut.getPrice(startDate, endDate, productId, brandId);
    //     verify(pricePort).getPrice(startDate, endDate, productId, brandId);
    // }

    // @Test
    // void create_whenPortReturnPrice_thenReturnCorrectly() {
    //     var startDate = Date.valueOf(LocalDate.of(2025, 1, 1));
	// 	var endDate = Date.valueOf(LocalDate.of(2025, 2, 1));
	// 	var productId = 1L;
	// 	var brandId = 1L;
	// 	var priceExpected = new Price(brandId, startDate, endDate, 1, productId, 1, new BigDecimal(123.45), "EUR");
    //     doReturn(priceExpected).when(pricePort).getPrice(startDate, endDate, productId, brandId);

    //     var result = sut.getPrice(startDate, endDate, productId, brandId);

    //     assertEquals(priceExpected, result);
    // }


}
