import java.util.Arrays;

public class Main {
    public static int[] input = {0, 0, 0};

    public static void main(String[] args) {
        String password = "111";
        Checker checker = new Checker(password);
        System.out.println(Arrays.toString(bruteforce(0, checker)));
    }

    public static int[] bruteforce(int cycleIndicator, Checker checker) {

        if (cycleIndicator == 0) {
            //cycle the last digit
            while (!checker.check(input) && input[0] != 9) {
                input[0]++;
                System.out.println(input[0]);
            }
            if (checker.check(input)) return input;
            //all combinations of last digit are false
            for (int j : input) {
                System.out.print(j);
            }

            input[0] = 0;
            bruteforce(1, checker);

        } else if (input[cycleIndicator] < 9) {
            if (checker.check(input)) return input;
            input[cycleIndicator]++;
            bruteforce(--cycleIndicator, checker);
        } else {//all combinations of this cycle have been false
            if (checker.check(input)) return input;
            //put all digits left of cycleIndicator to 0
            cycleIndicator++;
            for (int i = 0; i < cycleIndicator; i++) {
                input[i] = 0;
            }

            bruteforce(cycleIndicator, checker);
        }

        return input;
    }
}