import java.security.SecureRandom;
import java.util.Scanner;

public class Smith_p1 {
    //gets a random value
    public static int getRandom(int level) {

        SecureRandom random = new SecureRandom();

        //Used a Secure Random and added 1 to remove any zeros
        int value = random.nextInt(level) + 1;

        return value;
    }

    // Calls a multiplication problem
    public static int addition(int level){

        int value1 = getRandom(level), value2 = getRandom(level);
        int answer = value1 + value2;
        int correct = 0;

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is " + value1 + " + " + value2 + "?");
        int input = scnr.nextInt();

        if (input != answer) {

            getBadResponse();

        } else {

            getGoodResponse();
            correct++;

        }

        return correct;
    }

    // Calls a multiplication problem
    public static int multiplication(int level){

        int value1 = getRandom(level), value2 = getRandom(level);
        int answer = value1 * value2;
        int correct = 0;

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is " + value1 + " - " + value2 + "?");
        int input = scnr.nextInt();

        if (input != answer) {

            getBadResponse();

        } else {

            getGoodResponse();
            correct++;

        }

        return correct;
    }

    public static int subtraction(int level){

        int value1 = getRandom(level), value2 = getRandom(level);
        int answer = value1 - value2;
        int correct = 0;

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is " + value1 + " - " + value2 + "?");
        int input = scnr.nextInt();

        if (input != answer) {

            getBadResponse();

        } else {

            getGoodResponse();
            correct++;

        }

        return correct;
    }

    public static int division(int level){

        int value1 = getRandom(level), value2 = getRandom(level);
        double answer = ((double) value1) / value2;
        answer = Math.round(answer * 100);
        int correct = 0;

        Scanner scnr = new Scanner(System.in);

        System.out.println("For division round to the second decimal");

        System.out.println("What is " + value1 + " / " + value2 + "?");
        double input = scnr.nextDouble();
        input *= 100;

        if (((int)input) != ((int)answer)){

            getBadResponse();

        } else {

            getGoodResponse();
            correct++;

        }

        return correct;
    }
    
    public static char getGoodResponse(){

        String response = null;
        int value = getRandom(100) % 4 + 1;

        switch (value) {
            case 1:  response = "Very good!";
                break;
            case 2:  response = "Excellent!";
                break;
            case 3:  response = "Nice work!";
                break;
            case 4:  response = "Keep up the good work!";
                break;
        }

        System.out.println(response);

        return 0;
    }

    public static char getBadResponse(){

        String response = null;
        int value = getRandom(100) % 4 + 1;

        switch (value) {
            case 1:  response = "No. Please try again.";
                break;
            case 2:  response = "Wrong. Try once more.";
                break;
            case 3:  response = "Don’t give up!";
                break;
            case 4:  response = "No. Keep trying.";
                break;
        }

        System.out.println(response);

        return 0;
    }

    public static double grade(double score){

        System.out.println( "You got " + ((int)score) + " right and " + ((int)(10 - score)) + " wrong.");
        double percent = score / 10.0;
        System.out.println( "Your score is " + (percent * 100.0) + "%");


        if (score < 8) {

            System.out.println("Please ask your teacher for extra help.");

        } else {

            System.out.println("Congratulations, you are ready to go to the next level!");

        }

        return 0;
    }

    public static int level(){

        Scanner scnr = new Scanner(System.in);
        System.out.println("What level of difficulty do you want? (1-4)");
        int input = scnr.nextInt();
        int level = 0;

        while (input <  1 || input > 4){
            System.out.println("Please select appropriate difficulty? (1-4)");
            input = scnr.nextInt();
        }

            switch (input) {
                case 1:  level = 9;
                    break;
                case 2:  level = 99;
                    break;
                case 3:  level = 999;
                    break;
                case 4:  level = 9999;
                    break;
            }

        return level;
    }

    public static int multiplicationTest(int level){

        double correct = 0.0;

        for (int i = 0; i < 10; i++) {
            correct += multiplication(level);
        }

        grade(correct);

        return 0;
    }

    public static int additionTest(int level){

        double correct = 0.0;

        for (int i = 0; i < 10; i++) {
            correct += addition(level);
        }

        grade(correct);

        return 0;
    }

    public static int subtractionTest(int level){

        double correct = 0.0;

        for (int i = 0; i < 10; i++) {
            correct += subtraction(level);
        }

        grade(correct);

        return 0;
    }

    public static int divisionTest(int level){

        double correct = 0.0;

        for (int i = 0; i < 10; i++) {
            correct += division(level);
        }

        grade(correct);

        return 0;
    }

    public static int randomTest(int level){

        double correct = 0.0;
        int randomChoice = 0;

        for (int i = 0; i < 10; i++) {

            randomChoice = getRandom(10000) % 4 + 1;
            switch (randomChoice) {

                case 1:  addition(level);
                    break;
                case 2:  multiplication(level);
                    break;
                case 3:  subtraction(level);
                    break;
                case 4:  division(level);
                    break;

            }

        }

        grade(correct);

        return 0;
    }

    public static int test(){

        double correct = 0.0;
        int level = level();

        Scanner scnr = new Scanner(System.in);

        System.out.println("What type of math problem do you want? (1-4)");
        System.out.println("Addition       (1)");
        System.out.println("Multiplication (2)");
        System.out.println("Subtraction    (3)");
        System.out.println("Division       (4)");
        System.out.println("Random         (5)");

        int input = scnr.nextInt();

        while (input <  1 || input > 5){
            System.out.println("Please select appropriate choice? (1-4)");
            input = scnr.nextInt();
        }


        switch (input) {
            case 1:  additionTest(level);
                break;
            case 2:  multiplicationTest(level);
                break;
            case 3:  subtractionTest(level);
                break;
            case 4:  divisionTest(level);
                break;
            case 5:  randomTest(level);
                break;
        }

        return 0;
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input = 1;
        while (input == 1 ) {

            test();
            System.out.println("Type 1 for another attempt or 0 to quit?");
            input = scnr.nextInt();

            while (input < 0 || input > 1) {
                System.out.println("Please select appropriate choice? (1 or 0)");
                input = scnr.nextInt();
            }
        }
        System.out.println("Goodbye.");
    }

}
