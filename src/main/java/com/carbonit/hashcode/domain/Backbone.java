package com.carbonit.hashcode.domain;

import java.util.Objects;

public class Backbone {

    private final int row;
    private final int column;
    public final Position position;

    public Backbone(int row, int column) {
        this.row = row;
        this.column = column;
        this.position = new Position(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Backbone backbone = (Backbone) o;
        return row == backbone.row &&
                column == backbone.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Backbone{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
