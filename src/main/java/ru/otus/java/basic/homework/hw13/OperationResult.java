package ru.otus.java.basic.homework.hw13;

public class OperationResult extends Operation {

    private final int result;

    public OperationResult(Operation operation, int result) {
        this.operation = operation.getOperation();
        this.operandOne = operation.getOperandOne();
        this.operandTwo = operation.getOperandTwo();
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + result;
    }
}
