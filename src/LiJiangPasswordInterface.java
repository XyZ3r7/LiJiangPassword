public interface LiJiangPasswordInterface {
    // Yang Li, Linpei Jiang

    public int MINIMUM_LENGTH = 8;
    public int MAXIMUM_LENGTH = 20;
    public int ASCII_MAX_VALUE = 255;

    public int determineStrength() throws PasswordFormatException;
    public int length();
    public int differentConsecutiveTypes();
    public int upperAndLowerCase();
    public int consecutiveOrders();
    public int extraOccurrence();
    public int consecutiveSameChar();

}
