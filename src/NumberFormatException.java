public class NumberFormatException extends RuntimeException{
    private String explanation;
    public NumberFormatException(String explanation){
        super("Your password is too simple");
        this.explanation = explanation;
    }

    public void Explanation(){
        System.out.println(explanation);
    }

    public void PasswordFormatException(String explanation)
    {
        System.out.println("All good");
    }
}
