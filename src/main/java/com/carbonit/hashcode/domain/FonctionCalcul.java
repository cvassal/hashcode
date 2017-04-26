package com.carbonit.hashcode.domain;

/**
 * Created by bougadar on 26/04/17.
 */
public class FonctionCalcul {

    public static Position findRouterPlacement(Building building, Position routerInitiale, RouterRange range) {

        Position routeurPosition = routerInitiale;

        for (int i = 0; i <= range.getRange(); i++) {
            for (int j = 0; j <= range.getRange(); j++) {
                if (building.at(routerInitiale).equals(Cell.W)) {
                    return routerInitiale;
                } else {
                    routeurPosition = new Position(routerInitiale.rows + i, routerInitiale.columns + j);
                }
            }
        }
        return routeurPosition;
    }
}
