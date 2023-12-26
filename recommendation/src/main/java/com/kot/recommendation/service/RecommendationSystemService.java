package com.kot.recommendation.service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kot.recommendation.domain.RecommendationItem;
import com.kot.recommendation.repository.RecommendationItemRepository;

@Service
public class RecommendationSystemService {

    @Autowired
    private RecommendationItemRepository repository;

    public List<RecommendationItem> getTop5ItemsByUserId(UUID userId) {
        List<RecommendationItem> allItems = repository.findRecommendationItemsByUserId(userId);

        List<RecommendationItem> sortedItems = allItems.stream()
                .sorted(Comparator.comparing(RecommendationItem::getRecommendationValue).reversed())
                .toList();

        return sortedItems.size() > 5 ? sortedItems.subList(0, 5) : sortedItems;
    }
}
