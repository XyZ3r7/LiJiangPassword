import java.util.ArrayList;

import static java.lang.Character.*;

public class LiJiangPassword implements LiJiangPasswordI{
    private int strength;
    private String password;
    private int length;
    public LiJiangPassword(String password){
        this.password = password;
        this.length = password.length();
        strength = 0;
        consecutive();
        repeat();
        length();
        U_LCase();
    }

    /*
         This checks if the ASCII code of the values in the input String is +1 or -1
         For examples:
            abc - the ASCII code for a is 97, b is 98, c is 99. This will be -2
     */
    public void consecutive(){
        // Using the for loop to go from the first value to the last value
        for(int i = 1; i < length; i++)
        {
            // checks if the ASCII code is 1 number before or after
            if(password.charAt(i) == password.charAt(i - 1) + 1){
                // If so -1 each time
                strength--;
            }
        }
    }

    /*
        This Function processed and checked if a string is repeated in password
     */
    public void repeat(){
        /*
        We just add filtered character into whitelist to prevent repetition impact to strength
         */
        ArrayList <Character> whitelist = new ArrayList<Character>();
        /*
        Current implementation is for single character
         */
        char temp;
        int temp_counts = 0;
        String temp_string;
        boolean is_WhiteList = false;
        for(int i = 0; i < password.length();i++){
            temp = password.charAt(i);
            temp_counts = 0;
            temp_string = password.substring(i + 1);
            is_WhiteList = false;

            for(int j = 0; j < temp_string.length(); j++){
                for(int k = 0; k < whitelist.size();k++){
                    if(temp == whitelist.get(k)){
                        //get rid of this loop
                        is_WhiteList = true;
                        break;
                    }
                }

                if(is_WhiteList){
                    break;
                }

                if(temp_string.indexOf(temp) != -1){
                    temp_counts++;
                    temp_string = temp_string.substring(j + 1);
                }

                if(temp_counts >= 3){
                    whitelist.add(Character.valueOf(temp));
                    strength--;
                    break;
                }

            }
        }
    }

    /*
      This Function checked if the length is in the range of 8 - 20, and add score based on length
      If it is not in the range, we just throw an exception.
     */
    public void length(){
        if(length >= 17 && length <= 20){
            strength += 3;
        }else if (length >= 12){
            strength += 2;
        }else if (length >= 8){
            strength += 1;
        }else{
            throw new NumberFormatException("The length of password should be in range of 8 to 20.");
        }
    }

    /*
    This function checked if there's LowerCase and
     */
    public void U_LCase(){
        int Upper_Case = 0;
        int Lower_Case = 0;
        /*
        Find the number of Uppercase and Lowercase in password
         */
        for(int i = 0; i < password.length();i++){
            if(isUpperCase(password.charAt(i))){
                Upper_Case++;
            }else if(isLowerCase(password.charAt(i))){
                Lower_Case++;
            }
        }

        /*
        Add lower value to strength
         */
        strength += Math.min(Upper_Case, Lower_Case);

    }

    public void consecutive_diff_type(){
        boolean is_Character;
        for(int i = 1; i < password.length();i++){
            char temp = password.charAt(i);

            is_Character = isLetter(temp);
                //for character
            if(is_Character){
                if(!isLetter(password.charAt(i - 1))){
                    strength ++;
                }
                //for numbers
            }else if(temp >= 48 && temp <= 57){
                if(isLetter(password.charAt(i - 1)) || (password.charAt(i - 1) >= 48 && password.charAt(i - 1) <= 57)){
                    strength ++;
                }
                //for special notations
            }else{
                if(isLetter(password.charAt(i - 1)) || (password.charAt(i - 1) >= 48 && password.charAt(i - 1) <= 57)){
                    strength ++;
                }
            }




        }
    }

    /*
    Getter for passwordStrength
     */
    public int getStrength(){
        return strength;
    }

}
