public interface LiJiangPasswordInterface {
    // Yang Li, Linpei Jiang

    int MINIMUM_LENGTH = 8;
    int MAXIMUM_LENGTH = 20;
    int ASCII_MAX_VALUE = 255;

    int determineStrength() throws PasswordFormatException;
    int length();
    int differentConsecutiveTypes();
    int upperAndLowerCase();
    int consecutiveOrders();
    int extraOccurrence();
    int consecutiveSameChar();

}
