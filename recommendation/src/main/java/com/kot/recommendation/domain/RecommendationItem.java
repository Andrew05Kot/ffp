package com.kot.recommendation.domain;

import java.util.UUID;
import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "recommendation_item")
public class RecommendationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "recommendation_value", nullable = true)
    private Double recommendationValue;

    public RecommendationItem() {
    }

    public RecommendationItem(UUID userId, Long itemId, Double recommendationValue) {
        this.userId = userId;
        this.itemId = itemId;
        this.recommendationValue = recommendationValue;
    }

    public RecommendationItem(Long id, UUID userId, Long itemId, Double recommendationValue) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.recommendationValue = recommendationValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getRecommendationValue() {
        return recommendationValue;
    }

    public void setRecommendationValue(Double recommendationValue) {
        this.recommendationValue = recommendationValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof RecommendationItem that)) return false;

        return new EqualsBuilder().append(getId(), that.getId())
                .append(getUserId(), that.getUserId())
                .append(getItemId(), that.getItemId())
                .append(getRecommendationValue(), that.getRecommendationValue())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getUserId())
                .append(getItemId())
                .append(getRecommendationValue())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "RecommendationItem{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", recommendationValue=" + recommendationValue +
                '}';
    }
}
