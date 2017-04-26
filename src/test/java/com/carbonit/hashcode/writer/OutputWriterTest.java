package com.carbonit.hashcode.writer;

import static org.assertj.core.api.Assertions.*;

import com.carbonit.hashcode.domain.Position;
import org.junit.Test;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class OutputWriterTest {

	@Test
	public void should_write_3_cells_and_2_routers() throws Exception {
		Position cell1 = new Position(1, 2);
		Position cell2 = new Position(2, 3);
		Position cell3 = new Position(3, 9);
		Position router1 = new Position(3, 4);
		Position router2 = new Position(4, 9);
		URI uri = this.getClass()
		              .getClassLoader()
		              .getResource("output/result.out")
		              .toURI();

		new OutputWriter().addCable(cell1)
		                  .addCable(cell2)
		                  .addCable(cell3)
		                  .addRouter(router1)
		                  .addRouter(router2)
		                  .write("result.out");

		List<String> result = Files.lines(Paths.get(uri))
		                            .collect(Collectors.toList());
		assertThat(result).containsExactly("3", "1 2", "2 3", "3 9", "2", "3 4", "4 9");
	}
}