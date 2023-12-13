package com.kot.recommendation.domain;

import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "feature_vector")
public class FeatureVectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_id", nullable = false)
    private Long featureId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    public FeatureVectorModel() {
    }

    public FeatureVectorModel(Long featureId, Long itemId) {
        this.featureId = featureId;
        this.itemId = itemId;
    }

    public FeatureVectorModel(Long id, Long featureId, Long itemId) {
        this.id = id;
        this.featureId = featureId;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FeatureVectorModel that)) return false;

        return new EqualsBuilder().append(getId(), that.getId())
                .append(getFeatureId(), that.getFeatureId())
                .append(getItemId(), that.getItemId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getFeatureId())
                .append(getItemId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "FeatureVectorModel{" +
                "id=" + id +
                ", featureId=" + featureId +
                ", itemId=" + itemId +
                '}';
    }
}
