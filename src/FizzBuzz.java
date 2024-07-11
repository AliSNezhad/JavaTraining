import java.util.Scanner;

// To run test this class in the Main class, you can copy and paste these codes in the main class:

// FizzBuzz game = new FizzBuzz();
// game.run();

public class FizzBuzz {
    private Scanner scanner;

    public  FizzBuzz() {
        this.scanner = new Scanner(System.in);
    }

    private void fizzBuzzChecker(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }

    public void run() {
        while (true) {
            System.out.print("Enter your number to check or q to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting the program.");
                break;
            }

            try {
                int number = Integer.parseInt(input);
                fizzBuzzChecker(number);

            } catch (NumberFormatException e) {
                System.out.println("Enter an Integer value.");
            }
        }

        scanner.close();
    }

}