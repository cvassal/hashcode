package com.carbonit.hashcode.domain;

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
}
