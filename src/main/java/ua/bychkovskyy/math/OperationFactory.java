package ua.bychkovskyy.math;


import ua.bychkovskyy.errors.OperationNotFoundException;
import ua.bychkovskyy.math.impl.AddOperation;
import ua.bychkovskyy.math.impl.DivisionOperation;
import ua.bychkovskyy.math.impl.MultiplicationOperation;
import ua.bychkovskyy.math.impl.SubtractionOperation;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private Map<String, Operation> operationMap;

    public OperationFactory() {
        operationMap = new HashMap<String, Operation>();
        operationMap.put("+", new AddOperation());
        operationMap.put("-", new SubtractionOperation());
        operationMap.put("*", new MultiplicationOperation());
        operationMap.put("/", new DivisionOperation());
    }

    public Operation getOperation(String operationMark) throws OperationNotFoundException {
        Operation result = operationMap.get(operationMark);
        if (result == null) {
            throw new OperationNotFoundException(operationMark);
        }
        return result;
    }
}
