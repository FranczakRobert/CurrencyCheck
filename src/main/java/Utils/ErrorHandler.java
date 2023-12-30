package Utils;

import Enums.E_TYPE;

public class ErrorHandler {
    private static ErrorHandler instance;
    private static E_TYPE errorStatus;
    private ErrorHandler() {}

    public static ErrorHandler getInstance() {
        if(instance == null)
            instance = new ErrorHandler();
        return instance;
    }

    public void setErrorStatus(E_TYPE errorStatus) {
        ErrorHandler.errorStatus = errorStatus;
    }

    public E_TYPE getErrorStatus() {
        return errorStatus;
    }

}
