package com.carbonit.hashcode.domain;

public class Building {

    public final Cell t[][];

    public Building(int rows, int columns) {
        t = new Cell[rows][columns];
    }

}
