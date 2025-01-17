package com.bcnc.prueba.infrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bcnc.prueba.domain.model.Price;
import com.bcnc.prueba.infrastructure.price.exception.PriceNotFoundException;
import com.bcnc.prueba.infrastructure.price.persistence.adapter.PriceAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@SpringBootTest
public class PriceAdapterTest {

    @Autowired
    private PriceAdapter port;

    // simulo repository para controlar  el comportamiento sin acceder a la base de datos real
    // @Autowired
    // private PriceRepository repository;

    private ObjectMapper objectMapper;

    SimpleDateFormat formatter;

    @Test
    void contextLoads() {
        // Esta prueba verifica que el contexto de la aplicación se carga correctamente.
    }

    @Test
    public void main() {
      PriceApplication.main(new String[] {});
   }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        objectMapper.setDateFormat(formatter);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setTimeZone(TimeZone.getTimeZone("Europe/Madrid")); // zona horaria

        // given(repository.findPrice(any(), anyLong(), anyLong())).willReturn(Optional.of(new PriceEntity()));
    }

    // - Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    public void testGetPriceAt10On14th() throws ParseException {
        String dateStr = "2020-06-14-10.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-00.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());
        
        Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 0, BigDecimal.valueOf(35.50), "EUR");

        Price result = port.getPrice(testDate, 35455L, 1L);

        assertNotNull(result);
        assertEquals(expectedPrice, result);
    }

    // - Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    public void testGetPriceAt16On14th() throws ParseException {
        String dateStr = "2020-06-14-16.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-15.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-06-14-18.30.00").getTime());

        Price expectedPrice = new Price(1L, startDate, endDate, 2, 35455L, 1, BigDecimal.valueOf(25.45), "EUR");

        Price result = port.getPrice(testDate, 35455L, 1L);

        assertNotNull(result);
        assertEquals(expectedPrice, result);
    }
    // - Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
    // (ZARA)

    @Test
    void testGetPriceAt21On14th() throws Exception {
        String dateStr = "2020-06-14-21.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-14-00.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());

        Price expectedPrice = new Price(1L, startDate, endDate, 1, 35455L, 0, BigDecimal.valueOf(35.50), "EUR");
        Price result = port.getPrice(testDate, 35455L, 1L);

        assertNotNull(result);
        assertEquals(expectedPrice, result);

    }

    // - Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
    // (ZARA)

    @Test
    void testGetPriceAt10On15th() throws Exception {
        String dateStr = "2020-06-15-10.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-15-00.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-06-15-11.00.00").getTime());

        Price expectedPrice = new Price(1L, startDate, endDate, 3, 35455L, 1, BigDecimal.valueOf(30.50), "EUR");
        Price result = port.getPrice(testDate, 35455L, 1L);

        assertNotNull(result);
        assertEquals(expectedPrice, result);

    }

    // - Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
    // (ZARA)
    @Test
    void testGetPriceAt21On16th() throws Exception {
        String dateStr = "2020-06-16-21.00.00";
        Timestamp testDate = new Timestamp(formatter.parse(dateStr).getTime());
        Timestamp startDate = new Timestamp(formatter.parse("2020-06-15-16.00.00").getTime());
        Timestamp endDate = new Timestamp(formatter.parse("2020-12-31-23.59.59").getTime());

        Price expectedPrice = new Price(1L, startDate, endDate, 4, 35455L, 1, BigDecimal.valueOf(38.95), "EUR");
        Price result = port.getPrice(testDate, 35455L, 1L);

        assertNotNull(result);
        assertEquals(expectedPrice, result);

    }

    @Test
    void testPriceNotFoundException() throws Exception {
        String dateStr = "2021-06-17-10.00.00"; // Fecha que no existe en los datos
        Timestamp NotFoundTestDate = new Timestamp(formatter.parse(dateStr).getTime());

        // testea exception throwing
        assertThrows(PriceNotFoundException.class, () -> {
            port.getPrice(NotFoundTestDate, 35455L, 1L);
        });
    }

}
