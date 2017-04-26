package com.carbonit.hashcode.domain;

import com.carbonit.hashcode.HashCode;

/**
 * Created by bougadar on 26/04/17.
 */
public class FonctionCalcul {

    public static Position findRouterPlacement(Wireless map, Position routerInitiale, RouterRange range) {

        Position routeurPosition = routerInitiale;

        for (int i = 0; i <= range.getRange(); i++) {
            for (int j = 0; j <= range.getRange(); j++) {
                if (map.building.at(routerInitiale.row + i, routerInitiale.column + j).equals(Cell.W)) {
                    return routeurPosition;
                } else {
                    routeurPosition = new Position(routerInitiale.row + i, routerInitiale.column + j);
                }
            }
        }
        return routeurPosition;
    }

    public static Wireless putRouter(Wireless map, int budget, Price price, RouterRange radius) {
        //System.out.println(budget);
        //HashCode.print(map.building, map);
        if (budget <= price.getRouter() * 9 / 10) {
            return map;
        }

        Position position = map.firstTarget();
        if (position == null) return map;
        //System.out.println(position);
        Position routerPlacement = findRouterPlacement(map, position, radius);
        //System.out.println(routerPlacement);
        Wireless newMap = map.set(routerPlacement.row, routerPlacement.column, Cell.R);
        int newBudget = budget - price.getRouter();

        return putRouter(newMap, newBudget, price, radius);
    }
}