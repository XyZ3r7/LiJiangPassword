public interface LiJiangPasswordInterface {
    public int MINIMUM_LENGTH = 8;
    public int MAXIMUM_LENGTH = 20;

    public int determineStrength() throws PasswordFormatException;
    public int length();
    public int differentConsecutiveTypes();
    public int upperAndLowerCase();
    public int consecutiveOrders();
    public int extraOccurrence();
    public int consecutiveSameChar();

}
