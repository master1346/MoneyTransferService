package com.example.demo.operation;

public class ConfirmOperation {
    private String operationID;
    private String codeAuth;

    public ConfirmOperation(){}
    public ConfirmOperation(String operationID, String codeAuth){
        this.operationID = operationID;
        this.codeAuth = codeAuth;
    }

    public String getOperationID() {
        return operationID;
    }

    public void setOperationID(String operationID) {
        this.operationID = operationID;
    }

    public String getCodeAuth() {
        return codeAuth;
    }

    public void setCodeAuth(String codeAuth) {
        this.codeAuth = codeAuth;
    }


}
