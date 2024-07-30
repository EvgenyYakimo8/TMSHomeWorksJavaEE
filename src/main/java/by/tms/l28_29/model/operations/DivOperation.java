package by.tms.l28_29.model.operations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DivOperation implements Operation {

    double num1, num2;
    private String type;
    private double result;

    public DivOperation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    @Override
    public void execute() {
        this.result = num1 / num2;
    }

    @Override
    public double getResult() {
        return this.result;
    }
}