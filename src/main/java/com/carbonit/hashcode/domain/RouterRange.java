package com.carbonit.hashcode.domain;

import java.util.Objects;

public class RouterRange {

    private final int range;

    public RouterRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    };


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouterRange that = (RouterRange) o;
        return range == that.range;
    }

    @Override
    public int hashCode() {
        return Objects.hash(range);
    }

    @Override
    public String toString() {
        return "RouterRange{" +
                "range=" + range +
                '}';
    }
}
