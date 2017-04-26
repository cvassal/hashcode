package com.carbonit.hashcode.domain;

public class Wireless {

    public final Cell t[][];
    public final RouterRange routerRange;

    public Wireless(int rows, int columns, RouterRange routerRange) {
        this.routerRange = routerRange;
        t = new Cell[rows][columns];
    }

    public Wireless at(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
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
}
