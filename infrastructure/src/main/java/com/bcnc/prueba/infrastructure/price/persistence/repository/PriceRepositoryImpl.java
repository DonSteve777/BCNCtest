package com.bcnc.prueba.infrastructure.price.persistence.repository;

import java.sql.Timestamp;

import com.bcnc.prueba.infrastructure.price.persistence.model.PriceEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class PriceRepositoryImpl implements PriceRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PriceEntity findPrice(Timestamp applicationDate, Long productId, Long brandId) {
        String queryStr = "SELECT p FROM PriceEntity p WHERE p.startDate <= :applicationDate AND p.endDate >= :applicationDate AND p.productId = :productId AND p.brandId = :brandId"
         + " AND p.priority = (SELECT MAX(p2.priority) FROM PriceEntity p2 WHERE p2.startDate <= :applicationDate AND p2.endDate >= :applicationDate AND p2.productId = :productId AND p2.brandId = :brandId)";
        TypedQuery<PriceEntity> query = entityManager.createQuery(queryStr, PriceEntity.class);
        query.setParameter("applicationDate", applicationDate);
        query.setParameter("productId", productId);
        query.setParameter("brandId", brandId);
        return query.getSingleResult();
    }
}
