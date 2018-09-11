package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.Factoriel;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {

        //useMathEquation();
        //useCalculatorBase();
        //useCalculateHelper();


        String[] statements = {
                "add 25.0 92.0",
                "subtract 9.0 10.0",
                "divide 15.0 2.0",
                "multiply 11.0 9.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
            new Adder(), new Subtracter(), new Divider(), new Multiplier()
        });

        for (String statement:statements){
            String output = helper.process(statement);
            System.out.println(output);
        }



        /*
        //New instance for factorial calculation!
        MathEquation factorial = new MathEquation('f', 5.0d, 0.0d);
        factorial.execute();
        System.out.println("factorial result: " + factorial.getResult());
        */
    }

    /* //this is the other method than using constructor. We used a create method to initiliaze the MatEquation class
    MathEquation[] equations = new MathEquation[4];
    equations[0] = create(100.0d, 50.0d, 'd');
    equations[1] = create(25.0d, 92.0d, 'a');
    equations[2] = create(225.0d, 17.0d, 's');
    equations[3] = create(11.0d, 3.0d, 'm');

    public static MathEquation create(double leftVal, double rightVal, char opCode){
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }
    */

    static void useCalculateHelper(){

        String[] statements = {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",

                "multiply 11.0 3.0",

                //it's for testing exceptions...
                "dividex 100.0 50.0",
                "add aa 92.0",
                "subtract 225.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            }catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause() != null)
                    System.out.println("Original exception: " + e.getCause().getMessage());
            }
        }
    }

    static void useMathEquation(){
        MathEquation[] equations = new MathEquation[5];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 92.0d, 25.00d);
        equations[2] = new MathEquation('s', 17.0d, 8.0d);
        equations[3] = new MathEquation('m', 3.0d, 10.0d);
        equations[4] = new MathEquation('f', 5.0d);


        System.out.println("****Normal Class Structure Results********");
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result: " + equation.getResult());
        }
    }

    static void useCalculatorBase(){
        //Overloading
        MathEquation overLoadEquation = new MathEquation('d');
        overLoadEquation.execute(9,4);
        System.out.println("*******************");
        System.out.println("Overloading result: " + overLoadEquation.getResult());



        System.out.println("********************");
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d,50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
                new Factoriel(5.0d)
        };

        for(CalculateBase calculator:calculators){
            calculator.calculate();
            System.out.print("results=");
            System.out.println(calculator.getResult());
        }
    }

}
