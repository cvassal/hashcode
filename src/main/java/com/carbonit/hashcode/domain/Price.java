package com.carbonit.hashcode.domain;

import java.util.Objects;

public class Price {

    private final int backbone;
    private final int router;
    private final int budget;

    public Price(int backbone, int router, int budget) {
        this.backbone = backbone;
        this.router = router;
        this.budget = budget;
    }

    public int getBackbone() {
        return backbone;
    }

    public int getRouter() {
        return router;
    }

    public int getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return backbone == price.backbone &&
                router == price.router &&
                budget == price.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(backbone, router, budget);
    }

    @Override
    public String toString() {
        return "Price{" +
                "backbone=" + backbone +
                ", router=" + router +
                ", budget=" + budget +
                '}';
    }
}
