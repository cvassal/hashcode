package com.carbonit.hashcode.domain;

public class Backbone {

    private final int row;
    private final int column;


    public Backbone(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
