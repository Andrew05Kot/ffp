package com.kot.dish.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kot.dish.domain.LabelEntity;

@Repository
public interface LabelRepository extends CrudRepository<LabelEntity, Long>,
        JpaSpecificationExecutor<LabelEntity>,
        PagingAndSortingRepository<LabelEntity, Long> {

    LabelEntity findByName(String name);
}
