public class Checker {

    String password;
    public Checker(String password){
        this.password = password;
    }

    public boolean check(String input){
        return input.equals(password);
    }
}
