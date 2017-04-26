package com.carbonit.hashcode.reader;

import com.carbonit.hashcode.domain.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Integer.parseInt;

public class InputReader {

    public static Input read(URI fileName) throws IOException {
        Input input = new Input();
        Path path = Paths.get(fileName);
        Files.lines(path).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            int rows = parseInt(v[0]);
            int columns = parseInt(v[1]);
            input.building = new Building(rows, columns);
            input.routerRange = new RouterRange(parseInt(v[2]));
            input.wireless = new Wireless(rows, columns, input.routerRange);
        });
        Files.lines(path).skip(1).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.price = new Price(parseInt(v[0]), parseInt(v[1]), parseInt(v[2]));

        });

        Files.lines(path).skip(2).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.backbone = new Backbone(parseInt(v[0]), parseInt(v[1]));
        });
        return input;
    }

}
