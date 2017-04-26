package com.carbonit.hashcode.writer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWriter {

	private List<Coordinate> connectedCellsCoordinate;
	private List<Coordinate> routersCoordinate;

	public OutputWriter() {
		connectedCellsCoordinate = new ArrayList<>();
		routersCoordinate = new ArrayList<>();
	}

	public OutputWriter addConnectedCell(Coordinate connectedCell) {
		connectedCellsCoordinate.add(connectedCell);
		return this;
	}

	public OutputWriter addRouter(Coordinate router) {
		routersCoordinate.add(router);
		return this;
	}

	public void write(String fileName) {
		List<String> resultFileAsList = new ArrayList<>();

		resultFileAsList.add(String.valueOf(connectedCellsCoordinate.size()));
		resultFileAsList.addAll(connectedCellsCoordinate.stream()
		                                                .map(Coordinate::toString)
		                                                .collect(Collectors.toList()));

		resultFileAsList.add(String.valueOf(routersCoordinate.size()));
		resultFileAsList.addAll(routersCoordinate.stream()
		                                                .map(Coordinate::toString)
		                                                .collect(Collectors.toList()));

		try {
			URI uri = this.getClass()
			              .getClassLoader()
			              .getResource("output/" + fileName)
			              .toURI();
			Files.write(Paths.get(uri), resultFileAsList, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
