package com.kot.recommendation.api.mobile.v1;

import java.util.Set;
import lombok.Data;

@Data
public class RecommendationV1MobileResponse {

    private String userId;
    private Set<Long> recommendedDishesIds;

}
