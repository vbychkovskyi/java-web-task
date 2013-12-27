package ua.bychkovskyy.math.impl;


import ua.bychkovskyy.math.Operation;

public class DivisionOperation implements Operation {
    @Override
    public double doOperation(long a, long b) {
        return ((double) a) / ((double) b);
    }
}
