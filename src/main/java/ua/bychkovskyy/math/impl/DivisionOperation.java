package ua.bychkovskyy.math.impl;


import org.apache.log4j.Logger;
import ua.bychkovskyy.math.Operation;

public class DivisionOperation implements Operation {
    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public double doOperation(double a, double b) {
        logger.info(String.format("Division operands '%s' and '%s'", a, b));
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }
}
