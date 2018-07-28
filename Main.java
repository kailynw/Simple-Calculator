package com.kailynwilliams;


import java.util.Scanner;

public class Main {
    private static CalculatorFunctions calculatorFunctions= new CalculatorFunctions();
    private static Scanner intKeyboard= new Scanner(System.in);// integer
    private static Scanner charKeyboard= new Scanner(System.in);// char
    public static Scanner StringKeyboard= new Scanner(System.in);
    public static void main(String[] args) {
        introMessage();

        String answer="";
        char operator;

        do {
            System.out.println("Enter Number");
            int number1 = intKeyboard.nextInt();
            System.out.println("Enter an operator(+,-,/,*)");

            do {
                operator = charKeyboard.next().charAt(0);
            }while(!trueOperator(operator));

            System.out.println("Enter Number");
            int number2 = intKeyboard.nextInt();
             int total =processSum(operator, number1, number2);
            System.out.println("total= "+ total);

            System.out.println("Continue with total= "+total+"?(yes/no)");
            answer= StringKeyboard.nextLine();
            if(answer.equalsIgnoreCase("yes")){
               restart(total,operator,number2,answer);
            }

            decision(number1);
            answer= "yes";
        }while(answer.equalsIgnoreCase("yes"));
    }
    private static void introMessage(){
        System.out.println("Simple Calculator!");
        System.out.println("");
        System.out.println("Instructions:"+"\n + : For addition" +"\n - : For subtraction"+"\n * : For multiplication"+ "\n / : for division");
        System.out.println("Go!!");
    }
    private static int processSum(char operator, int value1, int value2) {

        switch (operator) {
            case '*': return multiply(value1, value2);
            case '/': return divide(value1, value2);
            case '-': return subtract(value1, value2);
            case '+': return add(value1, value2);

        }
        return -1;

    }

    private static int multiply(int value1, int value2){
        return calculatorFunctions.multiply(value1,value2);
    }
    private static int divide(int value1, int value2){
        return calculatorFunctions.divide(value1, value2);
    }
    private static int subtract(int value1, int value2){
        return calculatorFunctions.subtract(value1, value2);
    }
    private static int add(int value1, int value2){
        return calculatorFunctions.addition(value1, value2);
    }

    //Exception handling for operator
    private static boolean trueOperator(char operator) {
        if (operator == '*' || operator == '-' || operator == '+' || operator == '/') {
            return true;
        }
        System.out.println("Please enter valid operator");
        return false;
    }

    //Decides whether to end program or restart over
    private static void decision(int choiceNum){

        boolean done=true;
        while(done){
            System.out.println("1- End program \n2- Restart");
            choiceNum= intKeyboard.nextInt();
        switch(choiceNum) {
            case 1:
                System.exit(0);
            case 2:
                done=false;
                break;
            default:
                System.out.println("Invalid input. Please select the following numbers");
        }

        }
        }

        //Adds number to final total
        public static void restart(int lastTotal, char operator, int newNumber, String answer){

        if(answer.equalsIgnoreCase("yes")) {
            do {

                System.out.println("Total is " + lastTotal);
                System.out.println("");
                System.out.println("Type in operator");
                do {
                    operator = charKeyboard.next().charAt(0);
                } while (!trueOperator(operator));

                System.out.println("Enter Number");
                newNumber = intKeyboard.nextInt();
                int total = processSum(operator, lastTotal, newNumber);
                System.out.println("total= " + total);
                System.out.println("Continue?(yes/no)");
                answer= StringKeyboard.nextLine();
                lastTotal= total;
            }while(answer.equalsIgnoreCase("yes"));
        }


        }
    }


