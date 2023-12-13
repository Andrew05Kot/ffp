package com.kot.recommendation.api.mobile.v1;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kot.recommendation.api.common.ApiInfo;
import com.kot.recommendation.domain.RecommendationItem;
import com.kot.recommendation.service.RecommendationSystemService;

@RestController
@RequestMapping(RecommendationsV1MobileController.API_URL)
public class RecommendationsV1MobileController {

    public static final String API_URL = ApiInfo.API_PREFIX
            + ApiInfo.MOBILE_API_VERSION_V1
            + ApiInfo.RECOMMENDATION_ENDPOINT;

    @Autowired
    private RecommendationSystemService recommendationSystemService;

//    @GetMapping(value = "/top5/{userId}")
//    @ResponseBody
//    public ResponseEntity<RecommendationV1MobileResponse> getTop5RecommendationsByUser(@PathVariable String userId) {
//        UUID userUUID = UUID.fromString(userId);
//        List<RecommendationItem> recommendationItems = recommendationSystemService.getTop5ItemsByUserId(userUUID);
//
//        RecommendationV1MobileResponse recommendationV1MobileResponse = new RecommendationV1MobileResponse();
//        recommendationV1MobileResponse.setUserId(userId);
//        recommendationV1MobileResponse.setRecommendedDishesIds(recommendationItems.stream().map(ri -> ri.getItemId()).collect(Collectors.toSet()));
//
//        return new ResponseEntity<>(recommendationV1MobileResponse, HttpStatus.OK);
//    }

}
