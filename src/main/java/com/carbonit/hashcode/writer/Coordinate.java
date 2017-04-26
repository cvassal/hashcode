package com.carbonit.hashcode.writer;

public class Coordinate {

	private int rows;
	private int columns;

	public Coordinate(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	@Override
	public String toString() {
		return rows + " " + columns;
	}
}
