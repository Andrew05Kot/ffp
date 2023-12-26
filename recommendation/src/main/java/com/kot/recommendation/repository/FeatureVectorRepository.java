package com.kot.recommendation.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.recommendation.domain.FeatureVectorModel;

@Repository
public interface FeatureVectorRepository extends CrudRepository<FeatureVectorModel, Long>,
        JpaSpecificationExecutor<FeatureVectorModel>,
        PagingAndSortingRepository<FeatureVectorModel, Long> {
}
