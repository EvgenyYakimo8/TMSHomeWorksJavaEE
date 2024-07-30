package by.tms.l28_29.model.operations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubOperation implements Operation {

    private final double num1, num2;
    private final String type;
    private double result;

    public SubOperation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    @Override
    public void execute() {
        this.result = num1 - num2;
    }

    @Override
    public double getResult() {
        return this.result;
    }
}