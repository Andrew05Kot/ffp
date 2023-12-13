package com.kot.recommendation.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.recommendation.domain.RecommendationItem;

@Repository
public interface RecommendationItemRepository extends CrudRepository<RecommendationItem, Long>,
        JpaSpecificationExecutor<RecommendationItem>,
        PagingAndSortingRepository<RecommendationItem, Long> {

    List<RecommendationItem> findRecommendationItemsByUserId(UUID userId);

}
