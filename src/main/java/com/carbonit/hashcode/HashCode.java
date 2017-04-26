package com.carbonit.hashcode;

import com.carbonit.hashcode.domain.Building;
import com.carbonit.hashcode.domain.Cell;
import com.carbonit.hashcode.domain.RouterRange;
import com.carbonit.hashcode.domain.Wireless;

public class HashCode {

    public static void main(String... args) {
        Wireless networking = new Wireless(11, 11, new RouterRange(3));
        Building building = new Building(13, 13);

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                networking = networking.at(i, j, Cell.T);
            }
        }

        for(int i = 0; i < 13; i++) {
            building = building
                    .at(0, i, Cell.V)
                    .at(1, i, Cell.W)
                    .at(11, i, Cell.W)
                    .at(12, i, Cell.V)
                    .at(i, 0, Cell.V)
                    .at(i, 1, Cell.W)
                    .at(11, i, Cell.W)
                    .at(12, i, Cell.V);
        }

        networking.at(5, 5, Cell.R).print();
    }
}
