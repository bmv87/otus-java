package ru.otus.java.basic.homework.hw13;

import java.io.Serializable;

public class Operation implements Serializable {
    protected OperationsEnum operation;
    protected int operandOne;
    protected int operandTwo;

    public void setOperation(OperationsEnum operation) {
        this.operation = operation;
    }

    public void setOperandOne(int operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(int operandTwo) {
        this.operandTwo = operandTwo;
    }

    public OperationsEnum getOperation() {
        return operation;
    }

    public int getOperandOne() {
        return operandOne;
    }

    public int getOperandTwo() {
        return operandTwo;
    }

    @Override
    public String toString() {
        return operandOne +
                String.valueOf(operation.getSymbol()) +
                operandTwo +
                '=';
    }
}
