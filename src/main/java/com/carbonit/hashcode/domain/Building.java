package com.carbonit.hashcode.domain;

public class Building {

    public final Cell t[][];

    public Building(int rows, int columns) {
        t = new Cell[rows][columns];
    }

    public Building at(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
    }
}
