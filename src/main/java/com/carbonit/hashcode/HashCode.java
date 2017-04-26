package com.carbonit.hashcode;

import com.carbonit.hashcode.domain.*;
import com.carbonit.hashcode.reader.Input;
import com.carbonit.hashcode.reader.InputReader;
import com.carbonit.hashcode.writer.OutputWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class HashCode {

    public static void print(Building building, Wireless wireless, OutputWriter outputWriter) {
        for (int i = 0; i < wireless.rows; i++) {
            for (int j = 0; j < wireless.columns; j++) {
                Cell cell = wireless.at(i, j);
                switch (cell) {
                    case T:
                        System.out.printf(".");
                        break;
                    case C:
                        System.out.printf("C");
                        outputWriter.addCable(new Position(i,j));
                        break;
                    case TC:
                        System.out.printf("o");
                        break;
                    case R:
                        System.out.printf("R");
                        outputWriter.addCable(new Position(i,j));
                        outputWriter.addRouter(new Position(i,j));
                        break;
                    case B:
                        System.out.printf("B");
                        break;
                    default:
                        Cell buildingCell = building.at(i, j);
                        switch (buildingCell) {
                            case W:
                                System.out.printf("W");
                                break;
                            case T:
                                System.out.printf(".");
                                break;
                            default:
                                System.out.printf("_");
                        }

                }
            }
            System.out.println("");
        }
    }

    public static void main(String... args) throws URISyntaxException, IOException {
        final Stream<String> stream = Stream.of("sample");
        stream.forEach(name -> {
            try {
                OutputWriter outputWriter = new OutputWriter();
                Input input = InputReader.read(HashCode.class.getClassLoader().getResource("inputs/"+name+".in").toURI());
                Wireless result = FonctionCalcul.putRouter(input.wireless, input.price.getBudget(), input.price, input.routerRange, input.backbone.position);
                //result.connectRouters(input.backbone.position);
                HashCode.print(input.building, result, outputWriter);
                outputWriter.write(name + ".out");
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
}
