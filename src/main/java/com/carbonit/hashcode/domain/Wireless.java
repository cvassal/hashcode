package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Wireless {

    public final int rows;
    public final int columns;
    private final Cell t[][];
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


    public void connectRouter(int row, int column, Position backbonePos) {
        int x0 = 0;
        int y0 = 0;
        int x1 = 0;
        int y1 = 0;
        float dx = Math.abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
        float dy = Math.abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
        float err = (dx>dy ? dx : -dy)/2;

            while (true) {
                t[y0][x0] = Cell.C;
                if (x0 == x1 && y0 == y1) break;
                float e2 = err;
                if (e2 > -dx) { err -= dy; x0 += sx; }
                if (e2 < dy) { err += dx; y0 += sy; }
            }
    }

    public void connectRouters(Position backbonePos) {

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
