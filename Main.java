import java.util.Scanner;

public class Main {
    private static CalculatorFunctions calculatorFunctions = new CalculatorFunctions();
    private static Scanner intKeyboard = new Scanner(System.in);// integer input
    private static Scanner charKeyboard = new Scanner(System.in);// character input
    public static Scanner StringKeyboard = new Scanner(System.in);//String input

    public static void main(String[] args) {

            introMessage();

            String answer = "";
            char operator;

            do {
                System.out.println("Enter a number");
                int number1 = intKeyboard.nextInt();
                System.out.println("Enter an operator(+,-,/,*)");

                //Loops until correct operator is typed
                do {
                    operator = charKeyboard.next().charAt(0);
                } while (!calculatorFunctions.trueOperator(operator));
                // ^^^

                System.out.println("Enter a number");
                int number2 = intKeyboard.nextInt();
                int total = processSum(operator, number1, number2);
                System.out.println("total= " + total);

                System.out.println("Continue with total= " + total + "?(yes/no)");
                answer = StringKeyboard.nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    restart(total, operator, number2, answer);
                }

                decision(number1);
                answer = "yes";
            } while (answer.equalsIgnoreCase("yes"));
        }

        public static void introMessage(){
            System.out.println("Simple Calculator!");
            System.out.println("");
            System.out.println("Instructions:" + "\n + : For addition" + "\n - : For subtraction" + "\n * : For multiplication" + "\n / : For division");
            System.out.println("Go!!");
        }

        private static int processSum ( char operator, int value1, int value2){
            //Processes the operator and the two values to decide how to evaluate the total
            switch (operator) {
                case '*':
                    return calculatorFunctions.multiply(value1, value2);
                case '/':
                    return calculatorFunctions.divide(value1, value2);
                case '-':
                    return calculatorFunctions.subtract(value1, value2);
                case '+':
                    return calculatorFunctions.add(value1, value2);

            }
            return -1;
        }

        //Decides whether to end program or restart over
        private static void decision ( int choiceNum){

            boolean done = false;
            while (!done) {
                System.out.println("1- End program \n2- Restart");
                choiceNum = intKeyboard.nextInt();
                switch (choiceNum) {
                    case 1:
                        System.exit(0);
                    case 2:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please select the following numbers");
                }

            }
        }

        //Adds number to final total
        public static void restart ( int lastTotal, char operator, int newNumber, String answer){

            if (answer.equalsIgnoreCase("yes")) {
                do {

                    System.out.println("Total is " + lastTotal);
                    System.out.println("");
                    System.out.println("Type in operator");
                    do {
                        operator = charKeyboard.next().charAt(0);
                    } while (!calculatorFunctions.trueOperator(operator));

                    System.out.println("Enter Number");
                    newNumber = intKeyboard.nextInt();
                    int total = processSum(operator, lastTotal, newNumber);
                    System.out.println("total= " + total);
                    System.out.println("Continue?(yes/no)");
                    answer = StringKeyboard.nextLine();
                    lastTotal = total;
                } while (answer.equalsIgnoreCase("yes"));
            }
        }
    }