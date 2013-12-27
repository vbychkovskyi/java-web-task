package ua.bychkovskyy.math.impl;


import org.apache.log4j.Logger;
import ua.bychkovskyy.math.Operation;

public class DivisionOperation implements Operation {
    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public double doOperation(long a, long b) {
        logger.info(String.format("Division operands '%s' and '%s'", a, b));
        return ((double) a) / ((double) b);
    }
}
