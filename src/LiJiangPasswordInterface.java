public interface LiJiangPasswordInterface {
    // Yang Li, Linpei Jiang

    public final int MINIMUM_LENGTH = 8;
    public final int MAXIMUM_LENGTH = 20;
    public final int ASCII_MAX_VALUE = 255;

    public int determineStrength() throws PasswordFormatException;
    public int length();
    public int differentConsecutiveTypes();
    public int upperAndLowerCase();
    public int consecutiveOrders();
    public int extraOccurrence();
    public int consecutiveSameChar();

}
