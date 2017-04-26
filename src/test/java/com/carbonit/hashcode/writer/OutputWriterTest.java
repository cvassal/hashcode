package com.carbonit.hashcode.writer;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWriterTest {

	@Test
	public void should_write_3_cells_and_2_routers() throws Exception {
		Coordinate cell1 = new Coordinate(1, 2);
		Coordinate cell2 = new Coordinate(2, 3);
		Coordinate cell3 = new Coordinate(3, 9);
		Coordinate router1 = new Coordinate(3, 4);
		Coordinate router2 = new Coordinate(4, 9);
		URI uri = this.getClass()
		              .getClassLoader()
		              .getResource("output/result.out")
		              .toURI();

		new OutputWriter().addConnectedCell(cell1)
		                  .addConnectedCell(cell2)
		                  .addConnectedCell(cell3)
		                  .addRouter(router1)
		                  .addRouter(router2)
		                  .write("result.out");

		List<String> result = Files.lines(Paths.get(uri))
		                            .collect(Collectors.toList());
		assertThat(result).containsExactly("3", "1 2", "2 3", "3 9", "2", "3 4", "4 9");
	}
}