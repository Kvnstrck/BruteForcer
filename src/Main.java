import java.util.Arrays;

public class Main {
    public static int[] input = {0, 0, 0};

    public static void main(String[] args) {
        String password = "111";
        Checker checker = new Checker(password);
        System.out.println(bruteforce(0, checker));
    }

    public static String bruteforce(int cycleIndicator, Checker checker){
        return Arrays.toString(algorithm(cycleIndicator, checker));
    }

    public static int[] algorithm(int cycleIndicator, Checker checker) {

        if (cycleIndicator == 0) {
            //cycle the last digit
            while (!checker.check(buildInput(input)) && input[0] != 9) {
                input[0]++;
            }
            if (checker.check(buildInput(input))) return input;
            //all combinations of last digit are false

            input[0] = 0;
            bruteforce(1, checker);

        } else if (input[cycleIndicator] < 9) {
            input[cycleIndicator]++;
            bruteforce(--cycleIndicator, checker);
        } else {//all combinations of this cycle have been false
            //put all digits left of cycleIndicator to 0
            cycleIndicator++;
            for (int i = 0; i < cycleIndicator; i++) {
                input[i] = 0;
            }

            bruteforce(cycleIndicator, checker);
        }

        return input;
    }

    public static String buildInput(int[] input){
        StringBuilder password = new StringBuilder();
        for (int digit:input) {
            password.append(digit);
        }
        return password.toString();
    }
}