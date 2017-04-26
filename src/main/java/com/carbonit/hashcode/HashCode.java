package com.carbonit.hashcode;

import com.carbonit.hashcode.domain.FonctionCalcul;
import com.carbonit.hashcode.domain.Wireless;
import com.carbonit.hashcode.reader.Input;
import com.carbonit.hashcode.reader.InputReader;

import java.io.IOException;
import java.net.URISyntaxException;

import com.carbonit.hashcode.domain.Building;
import com.carbonit.hashcode.domain.Cell;
import com.carbonit.hashcode.domain.Wireless;
import com.carbonit.hashcode.reader.Input;
import com.carbonit.hashcode.reader.InputReader;
import com.carbonit.hashcode.writer.OutputWriter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.util.Collections.emptyList;

public class HashCode {



    public static void print(Building building, Wireless wireless) {
        for (int i = 0; i < wireless.rows; i++) {
            for (int j = 0; j < wireless.columns; j++) {
                Cell cell = wireless.at(i, j);
                switch (cell) {
                    case T:
                        System.out.printf(".");
                        break;
                    case C:
                        System.out.printf("C");
                        break;
                    case TC:
                        System.out.printf("o");
                        break;
                    case R:
                        System.out.printf("R");
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
        Input input = InputReader.read(HashCode.class.getClassLoader().getResource("inputs/charleston_road.in").toURI());
        Wireless result = FonctionCalcul.putRouter(input.wireless, input.price.getBudget(), input.price, input.routerRange);
    }
}
