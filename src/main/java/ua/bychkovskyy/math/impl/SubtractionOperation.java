package ua.bychkovskyy.math.impl;

import ua.bychkovskyy.math.Operation;

public class SubtractionOperation implements Operation {
    @Override
    public double doOperation(long a, long b) {
        return a - b;
    }
}
