package com.carbonit.hashcode.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WirelessTest {

    @Test
    public void should_expand_properly_router_range_even_with_walls() {
        Building building = new Building(13, 13);
        for(int i = 0; i < 13; i++) {
            building = building
                    .set(0, i, Cell.V)
                    .set(1, i, Cell.W)
                    .set(11, i, Cell.W)
                    .set(5, 7, Cell.W)
                    .set(12, i, Cell.V)
                    .set(i, 0, Cell.V)
                    .set(i, 1, Cell.W)
                    .set(11, i, Cell.W)
                    .set(12, i, Cell.V);
        }

        Wireless networking = new Wireless(11, 11, new RouterRange(3), building);
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                networking = networking.set(i, j, Cell.T);
            }
        }

        networking = networking.set(5, 5, Cell.R);
        assertThat(networking.at(5, 7)).isEqualTo(Cell.V);
        assertThat(networking.at(5, 6)).isEqualTo(Cell.TC);
    }
}
