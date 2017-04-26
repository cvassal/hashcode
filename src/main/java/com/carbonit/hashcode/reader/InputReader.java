package com.carbonit.hashcode.reader;

import com.carbonit.hashcode.domain.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class InputReader {

    public static Input read(URI fileName) throws IOException {
        Input input = new Input();
        Path path = Paths.get(fileName);
        final int[] rowsNumber = {0};
        final int[] columns = {0};
        Files.lines(path).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            rowsNumber[0] = parseInt(v[0]);
            columns[0] = parseInt(v[1]);
            input.building = new Building(rowsNumber[0], columns[0]);
            input.routerRange = new RouterRange(parseInt(v[2]));
        });

        Files.lines(path).skip(1).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.price = new Price(parseInt(v[0]), parseInt(v[1]), parseInt(v[2]));

        });

        Files.lines(path).skip(2).limit(1).forEach(s -> {
            String[] v = s.split(" ");
            input.backbone = new Backbone(parseInt(v[0]), parseInt(v[1]));
        });

        List<String> rows = Files.lines(path).skip(3).collect(Collectors.toList());
        for (int i = 0; i < input.building.rows; i++) {
            for (int j = 0; j < input.building.columns; j++) {
                char c = rows.get(i).charAt(j);
                switch (c) {
                    case '#':
                        input.building.set(i, j, Cell.W);
                        break;
                    case '.':
                        input.building.set(i, j, Cell.T);
                        break;
                    default:
                }
            }
        }
        input.wireless = new Wireless(rowsNumber[0], columns[0], input.routerRange, input.building);
        input.wireless.set(input.backbone.getRow(), input.backbone.getColumn(), Cell.B);

        return input;
    }

}
