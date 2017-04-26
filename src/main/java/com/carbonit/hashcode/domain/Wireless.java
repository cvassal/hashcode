package com.carbonit.hashcode.domain;

import java.util.Arrays;
import java.util.Objects;

public class Wireless {

    public final int rows;
    public final int columns;
    public Cell t[][];
    public final RouterRange routerRange;
    public final Building building;

    public Wireless(int rows, int columns, RouterRange routerRange, Building building) {
        this.routerRange = routerRange;
        this.building = building;
        this.t = new Cell[rows][columns];
        this.rows = rows;
        this.columns = columns;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                t[i][j] = Cell.V;
            }
        }
    }

    private Wireless(int rows, int columns, RouterRange routerRange, Building building, Cell[][] newCellMap) {
        this(rows, columns, routerRange, building);
        this.t = newCellMap;
        for (int i = 0; i < building.rows; i++) {
            for (int j = 0; j < building.columns; j++) {
                if(building.at(i, j) == Cell.W && i < this.t.length && j < this.t[0].length) {
                    t[i][j] = Cell.V;
                }
            }
        }
    }

    public Wireless set(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        if(toAdd == Cell.R) {
            return new Wireless(this.rows, this.columns, this.routerRange, this.building, expandRouterRange(row, column));
        }
        return this;
    }

    public Cell at(int row, int column) {
        return this.t[row][column];
    }

    private Cell[][] expandRouterRange(int row, int column) {
        Cell[][] newCellBoard = new Cell[this.t.length][this.t[0].length];
        for (int i = 0; i < this.t.length; i++) {
            System.arraycopy(this.t[i], 0, newCellBoard[i], 0, this.t[i].length);
        }

        int upRange = 0;
        for(int position = row; position >= 0; position--) {
            if(newCellBoard[position][column] != null && upRange <= this.routerRange.getRange() && this.building.at(position, column) != Cell.W) {
                newCellBoard = goLeftAndRight(position, column, newCellBoard);
                upRange += 1;
            }
            else {
                break;
            }
        }

        //Skipping the router row, which has been already processed
        int downRange = 1;
        for(int position = row + 1; position <= newCellBoard.length; position++) {
            if(newCellBoard[position][column] != null && downRange <= this.routerRange.getRange() && this.building.at(position, column) != Cell.W) {
                newCellBoard = goLeftAndRight(position, column, newCellBoard);
                downRange += 1;
            }
            else {
                break;
            }
        }

        return newCellBoard;
    }


    private Cell[][] goLeftAndRight(int position, int column, Cell[][] newCellBoard) {
        int leftRange = 0;
        for(int horizontal = column; horizontal >= 0; horizontal--) {
            Cell targetCell = this.t[position][horizontal];
            if(targetCell != null && leftRange <= this.routerRange.getRange() && this.building.at(position, horizontal) != Cell.W) {
                if(targetCell != Cell.R) {
                    newCellBoard[position][horizontal] = Cell.TC;
                }
                leftRange += 1;
            }
            else {
                break;
            }
        }

        int rightRange = 0;
        for(int horizontal = column; horizontal <= this.t[0].length; horizontal++) {
            Cell targetCell = this.t[position][horizontal];
            if(targetCell != null && rightRange <= this.routerRange.getRange() && this.building.at(position, horizontal) != Cell.W) {
                if(targetCell != Cell.R) {
                    newCellBoard[position][horizontal] = Cell.TC;
                }
                rightRange += 1;
            }
            else {
                break;
            }
        }
        return newCellBoard;
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
                        case R:
                            System.out.printf("R");
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
