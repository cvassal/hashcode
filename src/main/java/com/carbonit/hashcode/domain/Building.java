package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Building {

    public final Position position;
    public final Cell t[][];


    public Building(Position position) {
        this.position=position;
        t = new Cell[position.rows][position.columns];

        for (int i = 0; i < position.rows; i++) {
            for (int j = 0; j < position.columns; j++) {
                t[i][j] = Cell.V;
            }
        }
    }

    public Building set(Position position, Cell toAdd) {
        this.t[position.rows][position.columns] = toAdd;
        return this;
    }

    public Cell at(Position position) {
        return this.t[position.rows][position.columns];
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return position == building.position &&
                Arrays.equals(t, building.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, t);
    }

    @Override
    public String toString() {
        return "Building{" +
                "rows=" + position.rows +
                ", columns=" + position.columns +
                ", t=" + Arrays.toString(t) +
                '}';
    }

    public Cell getBuilding(Position position) {
        return t[position.rows][position.columns];
    }
}
