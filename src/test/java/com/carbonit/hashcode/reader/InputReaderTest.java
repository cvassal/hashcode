package com.carbonit.hashcode.reader;

import com.carbonit.hashcode.domain.Backbone;
import com.carbonit.hashcode.domain.Price;
import com.carbonit.hashcode.domain.RouterRange;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class InputReaderTest {

    @Test
    public void should_read_input() throws URISyntaxException, IOException {
        URI uri = this.getClass().getClassLoader().getResource("inputs/sample.in").toURI();
        Input input  = InputReader.read(uri);
        assertThat(input.backbone).isEqualTo(new Backbone(2,7));
        assertThat(input.price).isEqualTo(new Price(1, 100, 220));
        assertThat(input.routerRange).isEqualTo(new RouterRange(3));
        assertThat(input.building.rows).isEqualTo(8);
        assertThat(input.building.columns).isEqualTo(22);
        assertThat(input.wireless.rows).isEqualTo(8);
        assertThat(input.wireless.columns).isEqualTo(22);
    }
}