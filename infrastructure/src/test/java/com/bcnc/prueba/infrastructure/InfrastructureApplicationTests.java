package com.bcnc.prueba.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bcnc.prueba.infrastructure.price.rest.controller.PriceController;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceRequest;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bcnc.prueba.application.port.PriceInteractionPort;
import com.bcnc.prueba.domain.model.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.text.ParseException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.BDDMockito.given;


import java.math.BigDecimal;
import java.sql.Timestamp;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceInteractionPort port;

	private ObjectMapper objectMapper;

	SimpleDateFormat formatter;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
		formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		objectMapper.setDateFormat(formatter);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setTimeZone(TimeZone.getTimeZone("Europe/Madrid")); //zona horaria
	}
	 
// PRICES
// -------
// BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// 1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
// 1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
// 1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
// 1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR
 
	// - Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	@Test
    void testGetPriceAt10On14th() throws Exception {
		String dateStr = "2020-06-14-10.00.00";
		Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
		Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-00.00.00").getTime());
		Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());
		
		Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 0, BigDecimal.valueOf(35.50), "EUR");
		PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);
		PriceRequest request = new PriceRequest(testDate, 35455L, 1L);

		given(port.getPrice(any(), any(), any())).willReturn(expectedPrice);

		mockMvc.perform(get("/Prices")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(result -> {
					PriceResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);
					assertThat(response).isEqualTo(expectedResponse);
				});

		verify(port).getPrice(any(), any(), any());
	}
	// -          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	@Test
    void testGetPriceAt16On14th() throws Exception {
		String dateStr = "2020-06-14-16.00.00";
		Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
		Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-15.00.00").getTime());
		Timestamp endDate = new Timestamp(formatter.parse("2020-06-14-18.30.00").getTime());
		
		Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 1, BigDecimal.valueOf(25.45), "EUR");
		PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);
		PriceRequest request = new PriceRequest(testDate, 35455L, 1L);

		given(port.getPrice(any(), any(), any())).willReturn(expectedPrice);

		mockMvc.perform(get("/Prices")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(result -> {
					PriceResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);
					assertThat(response).isEqualTo(expectedResponse);
				});

	}
	// -    Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

	@Test
    void testGetPriceAt21On14th() throws Exception {
		String dateStr = "2020-06-14-21.00.00";
		Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
		Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-00.00.00").getTime());
		Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());
		
		Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 1, BigDecimal.valueOf( 35.50), "EUR");
		PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);
		PriceRequest request = new PriceRequest(testDate, 35455L, 1L);

		given(port.getPrice(any(), any(), any())).willReturn(expectedPrice);

		mockMvc.perform(get("/Prices")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(result -> {
					PriceResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);
					assertThat(response).isEqualTo(expectedResponse);
				});

	}

	// -          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

	@Test
    void testGetPriceAt10On15th() throws Exception {
		String dateStr = "2020-06-15-10.00.00";
		Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
		Timestamp startDate = new Timestamp(formatter.parse("2020-06-15-00.00.00").getTime());
		Timestamp endDate = new Timestamp(formatter.parse("2020-06-15-11.00.00").getTime());
		
		Price expectedPrice = new Price(1L, startDate, endDate, 3, 35455L, 1, BigDecimal.valueOf( 30.50), "EUR");
		PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);
		PriceRequest request = new PriceRequest(testDate, 35455L, 1L);

		given(port.getPrice(any(), any(), any())).willReturn(expectedPrice);

		mockMvc.perform(get("/Prices")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(result -> {
					PriceResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);
					assertThat(response).isEqualTo(expectedResponse);
				});

	}

	// -          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	@Test
    void testGetPriceAt21On16th() throws Exception {
		String dateStr = "2020-06-16-21.00.00";
		Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
		Timestamp startDate = new Timestamp(formatter.parse("2020-06-15-16.00.00").getTime());
		Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());
		
		Price expectedPrice = new Price(1L, startDate, endDate, 4, 35455L, 1, BigDecimal.valueOf( 38.95), "EUR");
		PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);
		PriceRequest request = new PriceRequest(testDate, 35455L, 1L);

		given(port.getPrice(any(), any(), any())).willReturn(expectedPrice);

		mockMvc.perform(get("/Prices")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(result -> {
					PriceResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponse.class);
					assertThat(response).isEqualTo(expectedResponse);
				});

	}

	

	

	 


}
