public class Checker {

    String password;
    public Checker(String password){
        this.password = password;
    }

    public boolean check(String password){
        return password.equals(this.password);
    }
}
