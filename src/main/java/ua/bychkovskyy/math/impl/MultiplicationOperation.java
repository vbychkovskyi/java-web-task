package ua.bychkovskyy.math.impl;


import org.apache.log4j.Logger;
import ua.bychkovskyy.math.Operation;

public class MultiplicationOperation implements Operation {
    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public double doOperation(double a, double b) {
        logger.info(String.format("Multiplication operands '%s' and '%s'", a, b));
        return a * b;
    }
}
