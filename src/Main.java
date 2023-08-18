import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String password = "bbb";
        Checker checker = new Checker(password);
        //System.out.println(bruteforce(checker));
    }

    public static boolean bruteforce(Checker checker) {

        ArrayList<Character> inputChars = new ArrayList<>();
        inputChars.add('a');
        //test for this length


        //set string back to just a's and add another one
        inputChars.replaceAll(ignored -> 'a');
        inputChars.add('a');
        System.out.println(inputChars);


        return false;
    }
}