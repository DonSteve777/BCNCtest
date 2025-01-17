package com.bcnc.prueba.infrastructure;

import com.bcnc.prueba.domain.model.Price;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceRequest;
import com.bcnc.prueba.infrastructure.price.rest.dto.PriceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private ObjectMapper objectMapper;

    SimpleDateFormat formatter;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        objectMapper.setDateFormat(formatter);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setTimeZone(TimeZone.getTimeZone("Europe/Madrid")); // zona horaria
    }

    @Test
    public void testGetPriceSuccess() throws Exception {
        String dateStr = "2020-06-14-10.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        PriceRequest request = new PriceRequest(testDate, 35455L, 1L);
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-00.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());

        Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 0, BigDecimal.valueOf(35.50), "EUR");

        PriceResponse expectedResponse = PriceResponse.toResponse(expectedPrice);

        HttpEntity<PriceRequest> requestEntity = new HttpEntity<>(request);
        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                "/Prices",
                HttpMethod.GET,
                requestEntity,
                PriceResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertThat(response.getBody(), is(equalTo(expectedResponse)));
    }

}