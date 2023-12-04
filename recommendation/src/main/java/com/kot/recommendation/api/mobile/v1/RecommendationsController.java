package com.kot.recommendation.api.mobile.v1;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kot.recommendation.api.common.ApiInfo;

@RestController
@RequestMapping(RecommendationsController.API_URL)
public class RecommendationsController {

    public static final String API_URL = ApiInfo.API_PREFIX
            + ApiInfo.MOBILE_API_VERSION_V1
            + ApiInfo.RECOMMENDATION_ENDPOINT;

    @GetMapping(value = "/top5")
    @ResponseBody
    public ResponseEntity<RecommendationV1MobileResponse> getTop5Recommendations() {
        return new ResponseEntity<>(getMockResponse(), HttpStatus.OK);
    }

    @GetMapping(value = "/top5/{userId}")
    @ResponseBody
    public ResponseEntity<RecommendationV1MobileResponse> getTop5RecommendationsByUser(@PathVariable String userId) {
        System.out.println("userId >> " + userId);
        return new ResponseEntity<>(getMockResponse(), HttpStatus.OK);
    }

    private RecommendationV1MobileResponse getMockResponse() {
        RecommendationV1MobileResponse model = new RecommendationV1MobileResponse();
        Set<String> dishIds = new HashSet<>();
        dishIds.add(UUID.randomUUID().toString());
        dishIds.add(UUID.randomUUID().toString());
        dishIds.add(UUID.randomUUID().toString());
        dishIds.add(UUID.randomUUID().toString());
        model.setRecommendedDishesIds(dishIds);
        model.setUserId(UUID.randomUUID().toString());
        return model;
    }
}
