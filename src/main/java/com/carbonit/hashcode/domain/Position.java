package com.carbonit.hashcode.domain;

public class Position {

    public final int rows;
    public final int columns;

    public Position(int row, int column) {
        this.rows = row;
        this.columns = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (rows != position.rows) return false;
        return columns == position.columns;
    }

    @Override
    public int hashCode() {
        int result = rows;
        result = 31 * result + columns;
        return result;
    }
}
