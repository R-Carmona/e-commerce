package com.rubencarmona.inditex.infrastructure.repository;

import com.rubencarmona.inditex.infrastructure.model.RateMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<RateMO, Long> {

    @Query("SELECT p FROM RateMO p WHERE p.brandId = ?1 AND p.productId = ?2 AND p.startDate <= ?3 AND p.endDate >= ?3 ORDER BY p.priority DESC")
    List<RateMO> findAllByBrandIdAndProductIdBetweenDates(Long brandId, Long productId, LocalDateTime dateBetween);
}

