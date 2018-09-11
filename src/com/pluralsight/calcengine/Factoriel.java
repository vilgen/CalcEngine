package com.pluralsight.calcengine;

public class Factoriel extends CalculateBase {

    public Factoriel(){}
    public Factoriel(double leftVal){
        super(leftVal);
    }

    @Override
    public void calculate() {
        int kVal = (int) getLeftVal();
        int factorial = 1;

        while (kVal>1){
            factorial *= kVal;
            kVal -= 1;
        }
        setResult(factorial);
    }


}
