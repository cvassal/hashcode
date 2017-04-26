package com.carbonit.hashcode.reader;

import com.carbonit.hashcode.domain.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputReader {

    public class Input {
        public Building building;
        public Wireless wireless;
        public Backbone backbone;
        public RouterRange routerRange;
        public Price price;
    }

    public Input read(URI fileName) throws IOException {
        Input input = new Input();
        Path path = Paths.get(fileName);
        Files.lines(path).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            int rows = Integer.parseInt(v[0]);
            int columns = Integer.parseInt(v[1]);
            input.building = new Building(rows, columns);
            input.wireless = new Wireless(rows, columns);
            input.routerRange = new RouterRange(Integer.parseInt(v[2]));
        });
        Files.lines(path).skip(1).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.price = new Price(Integer.parseInt(v[0]), Integer.parseInt(v[1]), Integer.parseInt(v[2]));

        });

        Files.lines(path).skip(2).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.backbone = new Backbone(Integer.parseInt(v[0]), Integer.parseInt(v[1]));
        });
        return input;
    }

}
