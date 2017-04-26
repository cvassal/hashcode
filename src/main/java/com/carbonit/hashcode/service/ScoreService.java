package com.carbonit.hashcode.service;

import com.carbonit.hashcode.domain.Price;

import java.math.BigDecimal;

public class ScoreService {

	private final static int TARGET_CELL_SCORE = 1000;

	public BigDecimal computeScore(Price price, Integer connectedCells, Integer connectedRouters, Integer connectedTargetedCells) {
		BigDecimal routers = new BigDecimal(connectedRouters * price.getRouter());
		BigDecimal cells = new BigDecimal(connectedCells * price.getCable());

		BigDecimal budgetScoring = new BigDecimal(price.getBudget()).subtract(routers)
		                                                       .subtract(cells);
		BigDecimal targetCellScore = new BigDecimal(TARGET_CELL_SCORE).multiply(new BigDecimal(connectedTargetedCells));
		return targetCellScore.add(budgetScoring);
	}

}
