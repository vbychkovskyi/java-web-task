package ua.bychkovskyy;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import ua.bychkovskyy.errors.OperationNotFoundException;
import ua.bychkovskyy.errors.ValidationException;
import ua.bychkovskyy.math.Operation;
import ua.bychkovskyy.math.OperationFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public class CalculateServlet extends HttpServlet {

    private OperationFactory operationFactory = new OperationFactory();

    private final Logger logger = Logger.getLogger(getClass());

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double result;
            JsonObject requestParams = parseParamsFromBody(req.getReader());

            double operand1 = validateAndParseOperand(requestParams.get("operand1").getAsString(), Message.INCORRECT_FIRST_OPERAND);
            double operand2 = validateAndParseOperand(requestParams.get("operand2").getAsString(), Message.INCORRECT_SECOND_OPERAND);

            String op = requestParams.get("operation").getAsString();
            Operation operation = operationFactory.getOperation(op);

            result = operation.doOperation(operand1, operand2);

            sendResponse(resp, Message.SUCCESS, result);

            logger.info(String.format("Calculated result of operation %s, with operands %s and %s", op, operand1, operand2) );

        } catch (OperationNotFoundException e) {
            logger.error("An exception thrown", e);
            sendResponse(resp, Message.OPERATION_NOT_FOUND, 0);
        } catch (ValidationException e) {
            logger.error("An exception thrown", e);
            sendResponse(resp, e.getMessage(), 0);
        } catch (ArithmeticException e) {
            logger.error("An exception thrown", e);
            sendResponse(resp, Message.DIVISION_BY_ZERO, 0);
        }
    }

    private JsonObject parseParamsFromBody(Reader reader) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(reader, JsonObject.class);
    }

    private double validateAndParseOperand(String operand, String violationMessage) throws ValidationException {
        try {
            return Double.parseDouble(operand);
        } catch (NumberFormatException nfe) {
            throw new ValidationException(violationMessage, nfe);
        }
    }

    private void sendResponse(HttpServletResponse response, String message, double result) throws IOException {
        JsonObject responseContent = new JsonObject();
        responseContent.addProperty("result", Double.toString(result));
        responseContent.addProperty("message", message);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(responseContent.toString());
        response.flushBuffer();
    }
}
