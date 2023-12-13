package com.kot.recommendation.api.backoffice.v1;

import java.util.Set;
import lombok.Data;

@Data
public class RecommendationV1Response {

    private String userId;
    private Set<Long> recommendedDishesIds;

}
