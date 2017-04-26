package com.carbonit.hashcode.domain;

public class Building {

    public final Cell t[][];

    public Building(int w, int h) {
        t = new Cell[w][h];
    }

    public Building at(int row, int column, Cell toAdd) {
        this.t[row][column] = toAdd;
        return this;
    }
}
