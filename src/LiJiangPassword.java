import static java.lang.Character.*;
// Yang Li, Linpei Jiang
public class LiJiangPassword implements LiJiangPasswordInterface{
    private final String password;
    private final int length;


    public LiJiangPassword(String password){
        this.password = password;
        length = password.length();

        // Testing purpose only
        // determineStrength();
        // System.out.println(length() + differentConsecutiveTypes() + upperAndLowerCase() + consecutiveOrders() + extraOccurrence() + consecutiveSameChar());
    }

    // Yang - determineStrength()
    /*
       determineStrength() checks if there is at least an uppercase, lowercase, letter,
       number, and a symbol, the password MUST be between 8 - 20 inclusively.

       first declare and set the 4 variable to false, then go through the password that,
       the user inputted to see if they have the 4 requirements. If so set it to true.

       check if the length of the password is between 8 - 20 inclusive or not, if not it will
       throw a PasswordFormatException, if it does pass the word limits, checks if all 4 variables
       are true, if they are true then the password can run the other methods to check the strength,
       or else it'll just throw another PasswordFormatException.
    */
    @Override
    public int determineStrength() throws PasswordFormatException {
        //Uppercase,lowercase,letter,numerical digit, and symbol
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean symbol = false;
        for (int i = 0; i < length; i++) {
            char current = password.charAt(i);
            if (isUpperCase(current)){
                upperCase = true;
            } else if (isLowerCase(current)) {
                lowerCase = true;
            } else if (isDigit(current)){
                digit = true;
            } else {
                symbol = true;
            }
        }

        //return the result
        if((length < MINIMUM_LENGTH || length > MAXIMUM_LENGTH)){
            throw new PasswordFormatException("Your password should be in range of 8 ~ 20");
        } else if (upperCase && lowerCase && digit && symbol) {
            return length() + differentConsecutiveTypes() + upperAndLowerCase() + consecutiveOrders() + extraOccurrence() + consecutiveSameChar();
        }else{
            throw new PasswordFormatException("Your password is missing at least one element: uppercase, lowercase, letter, digit or symbol");
        }
    }

    // Linpei - length()
    /*
        First taking the length of the password that the user inputted,
        make an int variable strength to store the strength and at the end to return.

        checks if the password is 8 - 11 inclusive, if so strength = 1
        checks if the password is 12 - 16 inclusive, then strength = 2
        checks if the password is 17 - 20 inclusive, then strength = 3
        else if none of the scoring conditions went through it would return 0,
        but in reality this would never return 0 because then it should be a PasswordFormatException.
    */
    @Override
    public int length() {
        int strength = 0;
        if(length >= 8 && length <= 11)
        {
            strength = 1;
        }
        else if(length >= 12 && length <=16)
        {
            strength = 2;
        }
        else if(length >= 17 && length <= 20)
        {
            strength = 3;
        }
        return strength;
    }

    // Yang - differentConsecutiveTypes()
    /*
        first declare all the variables needed for this helper method,
        go through the password String given by the input from the second character
        and checks with the character before that.

        the seris of the if and else if statements checks if the letter are different,
        for example the previous one is a digit, if the next one is ether a symbol or character,
        then strength +1. This they were the same thing then nothing happen.
    */
    @Override
    public int differentConsecutiveTypes() {
        int strength = 0;
        boolean digit;
        boolean symbol;
        boolean character;
        char previous;
        for (int i = 1; i < length; i++) {
            digit = isDigit(password.charAt(i));
            character = isLetter(password.charAt(i));
            symbol = !digit && !character;

            previous = password.charAt(i - 1);
            if(digit && !isDigit(previous)){
                strength ++;
            }else if (character && !isLetter(previous)){
                strength ++;
            }else if (symbol && (isDigit(previous) || isLetter(previous))){
                strength ++;
            }
        }

        return strength;
    }

    // Linpei - upperAndLowerCase()
    /*
        first create two int variables representing the number of uppercase and lowercase
        set to 0.

        in the for loop it is going to run from the start to the end to check how many
        upper and lowercase there is. But first we have to make sure that the password is a letter.
        By using isLetter(), checking if the password is a letter or not, if not then move on,
        if yes check if it is uppercase or lowercase.

        if uppercase just +1
        if lowercase just +1

        at the end if uppercaseNum is greater than lowercaseNum then return the lowercaseNum
        because we are counting the lower number between the two. So if lowercaseNum is greater,
        then return uppercaseNum.
    */
    @Override
    public int upperAndLowerCase() {
        int upperCaseNum = 0;
        int lowerCaseNum = 0;

        for(int i = 0; i < length; i++){
            if(isLetter(password.charAt(i))){
                if(isUpperCase(password.charAt(i))){
                    upperCaseNum++;
                }
                else if(isLowerCase(password.charAt(i))){
                    lowerCaseNum++;
                }
            }
        }

        if(upperCaseNum >= lowerCaseNum)
        {
            return lowerCaseNum;
        }
        else
        {
            return upperCaseNum;
        }
    }

    // Yang - consecutiveOrders()
    /*
        this helper method is going to use the ascii code. First create all the variables,
        then in the for loop it will start at index 1, which is the second character.
        set the current character to the char at position i, previous character is the
        char one index before index i.

        in the if statement, if the char current + 1 index is equal to the previous char value
        or the one before is qual to the current char. Check again if both of the char is a letter
        or a digit or not, if so strength -1.
    */
    @Override
    public int consecutiveOrders() {
        int strength = 0;
        char current, previous;
        for (int i = 1; i < length; i++) {
            current = password.charAt(i);
            previous = password.charAt(i - 1);
            if((current + 1 == previous || current - 1 == previous)
                    && ((isLetter(current) && isLetter(previous))
                    || (isDigit(current)  && isDigit(previous)))){
                strength--;
            }
        }
        return strength;
    }

    // Yang - extraOccurrence()
    /*
        *Reimplemented due to poor readability and efficiency
        Using frequency array to quickly find out repeated character/digit/symbol and save the repeated times as value.
        Then, loop again to check if there's any character/digit/symbol repeated more than twice.
    */
    @Override
    public int extraOccurrence() {
        int strength = 0;
        int[] frequency = new int[ASCII_MAX_VALUE + 1];
        for(int i = 0; i < length; i++){
            frequency[password.charAt(i)] += 1;
        }

        for (int i = 0; i < ASCII_MAX_VALUE + 1; i++) {
            if (frequency[i] >= 3){
                strength -= frequency[i] - 2;
            }
        }

        return strength;
    }

    // Yang - consecutiveSameChar()
    /*
        in this helper method, it will lose strength if the character repeats 3 or more times.
        in the for loop the index starts at the first character and goes 2 characters before the end,
        if the current password is the same to the next and the next, then -1 strength.
    */
    @Override
    public int consecutiveSameChar() {
        int strength = 0;
        char current;
        for (int i = 0; i < length - 2; i++) {
            current = password.charAt(i);
            if(password.charAt(i + 1) == current
                    && password.charAt(i + 2) == current){

                strength--;
            }
        }
        return strength;
    }
}
