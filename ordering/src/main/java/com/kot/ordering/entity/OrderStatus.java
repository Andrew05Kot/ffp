package com.kot.ordering.entity;

public enum OrderStatus {
    PENDING("Pending"),
    PROCESSING("Processing"),
    PAYED("PAYED"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    RECEIVED("received"),
    CANCELED("Canceled");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
