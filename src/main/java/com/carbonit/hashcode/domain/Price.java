package com.carbonit.hashcode.domain;

import java.util.Objects;

public class Price {

    private final int cable;
    private final int router;
    private final int budget;

    public Price(int cable, int router, int budget) {
        this.cable = cable;
        this.router = router;
        this.budget = budget;
    }

    public int getCable() {
        return cable;
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
        return cable == price.cable &&
                router == price.router &&
                budget == price.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cable, router, budget);
    }

    @Override
    public String toString() {
        return "Price{" +
                "cable=" + cable +
                ", router=" + router +
                ", budget=" + budget +
                '}';
    }
}
