package com.carbonit.hashcode.domain;

/**
 * Created by yannickgrenzinger on 26/04/2017.
 */
public class Price {

    private final int backbone;
    private final int cable;
    private final int router;

    public Price(int backbone, int cable, int router) {
        this.backbone = backbone;
        this.cable = cable;
        this.router = router;
    }

    public int getBackbone() {
        return backbone;
    }

    public int getCable() {
        return cable;
    }

    public int getRouter() {
        return router;
    }
}
