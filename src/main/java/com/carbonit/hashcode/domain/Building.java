package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Building {

    public final int rows;
    public final int columns;
    private final Cell t[][];

    public Building(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        t = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                t[i][j] = Cell.V;
            }
        }
    }

    public Building set(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
    }

    public Cell at(Position position) {
        return this.t[position.rows][position.columns];
    }

    public Cell at(int row, int column) {
        return this.t[row][column];
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
