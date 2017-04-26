package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Building {

    public final int rows;
    public final int columns;
    public final Cell t[][];

    public Building(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        t = new Cell[rows][columns];
    }

    public Building at(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return rows == building.rows &&
                columns == building.columns &&
                Arrays.equals(t, building.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, t);
    }

    @Override
    public String toString() {
        return "Building{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", t=" + Arrays.toString(t) +
                '}';
    }
}
