package com.kot.recommendation.domain;

import java.util.UUID;
import javax.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "preferences_vector")
public class PreferencesVectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "feature_id", nullable = false)
    private Long featureId;

    public PreferencesVectorModel() {
    }

    public PreferencesVectorModel(UUID userId, Long featureId) {
        this.userId = userId;
        this.featureId = featureId;
    }

    public PreferencesVectorModel(Long id, UUID userId, Long featureId) {
        this.id = id;
        this.userId = userId;
        this.featureId = featureId;
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

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PreferencesVectorModel that)) return false;

        return new EqualsBuilder().append(getId(), that.getId())
                .append(getUserId(), that.getUserId())
                .append(getFeatureId(), that.getFeatureId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId())
                .append(getUserId())
                .append(getFeatureId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "PreferencesVectorModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", featureId=" + featureId +
                '}';
    }
}
