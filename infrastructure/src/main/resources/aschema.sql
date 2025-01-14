
-- CREATE TABLE GROUPS (
--     BRAND_ID BIGINT NOT NULL,
--     PRIMARY KEY (BRAND_ID)
-- );
CREATE TABLE PRICES (
    BRAND_ID BIGINT NOT NULL,
    START_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
    END_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
    PRICE_LIST INT NOT NULL,
    PRODUCT_ID BIGINT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL,
    CURR VARCHAR(3) NOT NULL,
    PRIMARY KEY (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID)
    -- ,FOREIGN KEY (BRAND_ID) REFERENCES GROUPS(BRAND_ID)
);






-- BRAND_ID         START_DATE                                    END_DATE                        PRICE_LIST                   PRODUCT_ID  PRIORITY                 PRICE           CURR
-- ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 1         2020-06-14-00.00.00                        2020-12-31-23.59.59                        1                        35455                0                        35.50            EUR
-- 1         2020-06-14-15.00.00                        2020-06-14-18.30.00                        2                        35455                1                        25.45            EUR
-- 1         2020-06-15-00.00.00                        2020-06-15-11.00.00                        3                        35455                1                        30.50            EUR
-- 1         2020-06-15-16.00.00                        2020-12-31-23.59.59                        4                        35455                1                        38.95            EUR

-- BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
-- START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
-- PRICE_LIST: Identificador de la tarifa de precios aplicable.
-- PRODUCT_ID: Identificador código de producto.
-- PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
-- PRICE: precio final de venta.
-- CURR: iso de la moneda.