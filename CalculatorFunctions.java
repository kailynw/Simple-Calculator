//Functions for the calculator to do calculations
public class CalculatorFunctions {

        public int multiply(int input1, int input2){
            return input1*input2;
        }

        public int add(int input1, int input2){
            return input1+input2;
        }

        public int subtract(int input1, int input2){
            return input1-input2;

        }

        public int divide(int input1, int input2){
            return input1/input2;
        }



    //Method decides if operator is valid or not(+,-,/,*)
    public boolean trueOperator ( char operator){
        if (operator == '*' || operator == '-' || operator == '+' || operator == '/') {
            return true;
        }
        System.out.println("Please enter valid operator");
        return false;
    }



    }
