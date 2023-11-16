package org.primeTest;

public class ProgramException extends Exception {
    private final String errorMessage;
    public ProgramException(String errorMessage, Exception e) {
        this.errorMessage = errorMessage + ", " + e.getMessage();
    }
    public ProgramException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
