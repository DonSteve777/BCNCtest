package com.bcnc.prueba.infrastructure.price.persistence.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bcnc.prueba.infrastructure.price.persistence.model.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("SELECT p FROM PriceEntity p WHERE p.startDate <= :applicationDate AND p.endDate >= :applicationDate AND p.productId = :productId AND p.brandId = :brandId " +
    "AND p.priority = (SELECT MAX(p2.priority) FROM PriceEntity p2 WHERE p2.startDate <= :applicationDate AND p2.endDate >= :applicationDate AND p2.productId = :productId AND p2.brandId = :brandId)")
    Optional<PriceEntity> findPrice(@Param("applicationDate") Timestamp applicationDate, 
                                   @Param("productId") Long productId, 
                                   @Param("brandId") Long brandId);
}