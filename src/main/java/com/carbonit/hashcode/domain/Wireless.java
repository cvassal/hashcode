package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Wireless {

    public final int rows;
    public final int columns;
    public final Cell t[][];
    public final RouterRange routerRange;

    public Wireless(int rows, int columns, RouterRange routerRange) {
        this.routerRange = routerRange;
        t = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                t[i][j] = Cell.V;
            }
        }
    }

    public Wireless set(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
    }

    public Cell at(int row, int column) {
        return this.t[row][column];
    }

    public void print() {
        for (Cell[] aT : this.t) {
            for (Cell anAT : aT) {
                if(anAT != null) {
                    switch (anAT) {
                        case T:
                            System.out.printf(".");
                            break;
                        case TC:
                            System.out.printf("$");
                            break;
                    }
                }
                else {
                    System.out.printf("-");
                }
            }
            System.out.println();
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wireless wireless = (Wireless) o;
        return rows == wireless.rows &&
                columns == wireless.columns &&
                Arrays.equals(t, wireless.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, t);
    }

    @Override
    public String toString() {
        return "Wireless{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", t=" + Arrays.toString(t) +
                '}';
    }
}
