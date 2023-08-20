public class Checker {

    String password;
    public Checker(String password){
        this.password = password;
    }

    public boolean check(int[] input){
        String password = "";
        for (int digit:input) {
            password+=digit;
        }
        return password.equals(this.password);
    }
}
