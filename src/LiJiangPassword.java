import static java.lang.Character.*;

public class LiJiangPassword implements LiJiangPasswordInterface{
    private String password;
    private int length;

    public LiJiangPassword(String password){
        this.password = password;
        length = password.length();
        System.out.println(MAXIMUM_LENGTH);
    }

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

    @Override
    public int differentConsecutiveTypes() {
        int strength = 0;
        boolean digit = false;
        boolean symbol = false;
        boolean character = false;
        char previous;
        for (int i = 1; i < length; i++) {
            digit = isDigit(password.charAt(i));
            character = isLetter(password.charAt(i));
            symbol = !digit && !character;

            previous = password.charAt(i - 1);
            if(digit && isDigit(previous)){
                strength ++;
            }else if (character && isLetter(previous)){
                strength ++;
            }else if (symbol && !isDigit(previous) && !isLetter(previous)){
                strength ++;
            }
        }

        return strength;
    }

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

    @Override
    public int extraOccurrence() {
        int strength = 0;
        char current;
        int count;
        for (int i = 0; i < length; i++) {
            current = password.charAt(i);
            count = 0;
            for (int j = i; j < length; j++) {
                if (current == password.charAt(j)){
                    count++;
                }
                if(count == 3){
                    strength--;
                    break;
                }
            }
        }

        return strength;
    }

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
