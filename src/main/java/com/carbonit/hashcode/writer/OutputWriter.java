package com.carbonit.hashcode.writer;

import com.carbonit.hashcode.domain.Position;

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

	private List<Position> cables;
	private List<Position> routers;

	public OutputWriter() {
		cables = new ArrayList<>();
		routers = new ArrayList<>();
	}

	public OutputWriter addCable(Position cable) {
		cables.add(cable);
		return this;
	}

	public OutputWriter addRouter(Position router) {
		routers.add(router);
		return this;
	}

	public void write(String fileName) {
		List<String> resultFileAsList = new ArrayList<>();

		resultFileAsList.add(String.valueOf(cables.size()));
		resultFileAsList.addAll(cables.stream()
		                                                .map(Position::toString)
		                                                .collect(Collectors.toSet()));

		resultFileAsList.add(String.valueOf(routers.size()));
		resultFileAsList.addAll(routers.stream()
		                                                .map(Position::toString)
		                                                .collect(Collectors.toList()));

		try {
			URI uri = this.getClass()
			              .getClassLoader()
			              .getResource("output/" + fileName)
			              .toURI();
			Files.write(Paths.get(uri), resultFileAsList, StandardOpenOption.CREATE);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
