package com.carbonit.hashcode.service;

import com.carbonit.hashcode.domain.Price;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.math.BigDecimal;

public class ScoreServiceTest {

	private ScoreService scoreService = new ScoreService();

	@Test
	public void should_score_1000_with_one_router() throws Exception {
		Price price = new Price(1, 100, 1100);

		BigDecimal actual = scoreService.computeScore(price, 0, 1, 0);

		assertThat(actual).isEqualTo(new BigDecimal(1000));
	}

	@Test
	public void should_score_1000_with_one_cell() throws Exception {
		Price price = new Price(100, 1, 1100);

		BigDecimal actual = scoreService.computeScore(price, 1, 0, 0);

		assertThat(actual).isEqualTo(new BigDecimal(1000));
	}

	@Test
	public void should_score_1000_with_one_targeted_cell_covered() throws Exception {
		Price price = new Price(1, 1, 0);

		BigDecimal actual = scoreService.computeScore(price, 0, 0, 1);

		assertThat(actual).isEqualTo(new BigDecimal(1000));
	}

	@Test
	public void should_score_with_complexe_data() throws Exception {
		Price price = new Price(3, 87, 1000000);

		BigDecimal actual = scoreService.computeScore(price, 14, 4, 66);

		assertThat(actual).isEqualTo(new BigDecimal(1065610));
	}


}