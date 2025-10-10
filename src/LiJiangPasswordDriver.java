public class LiJiangPasswordDriver {
    // Yang Li, Linpei Jiang
    public static void main(String[] args) {

         // Linpei
         // Test for method 1 (i)
         LiJiangPassword testForMethod1 = new LiJiangPassword("LiJiang123."); // should not throw PasswordFormatException()
         System.out.println("Method 1 test: " + testForMethod1.determineStrength());

         // Test for method 2 (ii)
         LiJiangPassword testForMethod2TestOne = new LiJiangPassword("fbewkfbefb");           // length of 10 (+1)
         LiJiangPassword testForMethod2TestTwo = new LiJiangPassword("fbewkfbefbfgd");        // length of 13 (+2)
         LiJiangPassword testForMethod2TestThree = new LiJiangPassword("fbewkfbdjso8efbfgd"); // length of 18 (+3)
         System.out.println("Method 2 test: " + testForMethod2TestOne.length());
         System.out.println("Method 2 test: " + testForMethod2TestTwo.length());
         System.out.println("Method 2 test: " + testForMethod2TestThree.length());

         // Test for method 3 (iii)
         LiJiangPassword testForMethod3TestOne = new LiJiangPassword("abc123&"); // Earn 2 strength (+2)
         LiJiangPassword testForMethod3TestTwo = new LiJiangPassword("a!1ba^");  // Earn 4 Strength (+4)
         System.out.println("Method 3 test: " + testForMethod3TestOne.differentConsecutiveTypes());
         System.out.println("Method 3 test: " + testForMethod3TestTwo.differentConsecutiveTypes());

         // Test for method 4 (iv)
         LiJiangPassword testForMethod4TestOne = new LiJiangPassword("ABcDe123!"); // Earn 2 strength (+2)
         System.out.println("Method 4 test: " + testForMethod4TestOne.upperAndLowerCase());

         // Test for method 5 (v)
         LiJiangPassword testForMethod5TestOne = new LiJiangPassword("abcde");   // Lose 4 strength
         LiJiangPassword testForMethod5TestTwo = new LiJiangPassword("abc4321"); // Lose 5 strength
         LiJiangPassword testForMethod5TestThree = new LiJiangPassword("zyx78"); // Lose 3 strength
         System.out.println("Method 5 test: " + testForMethod5TestOne.consecutiveOrders());
         System.out.println("Method 5 test: " + testForMethod5TestTwo.consecutiveOrders());
         System.out.println("Method 5 test: " + testForMethod5TestThree.consecutiveOrders());

         // Test for method 6 (vi)
         LiJiangPassword testForMethod6TestOne = new LiJiangPassword("xaxbxc");    // Lose 1 strength
         LiJiangPassword testForMethod6TestTwo = new LiJiangPassword("xaxbc");     // Lose no strength
         LiJiangPassword testForMethod6TestThree = new LiJiangPassword("axaxaxa"); // Lose 3 strength
         System.out.println("Method 6 test: " + testForMethod6TestOne.extraOccurrence());
         System.out.println("Method 6 test: " + testForMethod6TestTwo.extraOccurrence());
         System.out.println("Method 6 test: " + testForMethod6TestThree.extraOccurrence());

         // Test for method 7 (vii)
         LiJiangPassword testForMethod7TestOne = new LiJiangPassword("look");  // Lose no strength
         LiJiangPassword testForMethod7TestTwo = new LiJiangPassword("loook"); // Lose 1 strength
         System.out.println("Method 7 test: " + testForMethod7TestOne.consecutiveSameChar());
         System.out.println("Method 7 test: " + testForMethod7TestTwo.consecutiveSameChar());

        // Test for the whole password - Linpei and Yang
        LiJiangPassword testForPasswordOne = new LiJiangPassword("Abcde123@"); // Strength = -1
        System.out.println("Strength for test 1 is: " + testForPasswordOne.determineStrength());

        LiJiangPassword testForPasswordTwo = new LiJiangPassword("Password1&"); // Strength = 4
        System.out.println("Strength for test 2 is: " + testForPasswordTwo.determineStrength());

        LiJiangPassword testForPasswordThree = new LiJiangPassword("Apple92&"); // Strength = 4
        System.out.println("Strength for test 3 is: " + testForPasswordThree.determineStrength());

        LiJiangPassword testForPasswordFour = new LiJiangPassword("Apple98&"); // Strength = 3
        System.out.println("Strength for test 4 is: " + testForPasswordFour.determineStrength());

        LiJiangPassword testForPasswordFive = new LiJiangPassword("banaNa12&"); // Strength = 1
        System.out.println("Strength for test 5 is: " + testForPasswordFive.determineStrength());

        LiJiangPassword testForPasswordSix = new LiJiangPassword("@Cheese1!a@cc"); // Strength = 8
        System.out.println("Strength for test 6 is: " + testForPasswordSix.determineStrength());

        LiJiangPassword testForPasswordSeven = new LiJiangPassword("@Cheese1!a@ccc"); // Strength = 6
        System.out.println("Strength for test 7 is: " + testForPasswordSeven.determineStrength());

        LiJiangPassword testForPasswordEight = new LiJiangPassword("@Cheeese1!a@ccc"); // Strength = 4
        System.out.println("Strength for test 8 is: " + testForPasswordEight.determineStrength());

        LiJiangPassword testForPasswordNine = new LiJiangPassword("@CheESe1!a@cc"); // Strength = 11
        System.out.println("Strength for test 9 is: " + testForPasswordNine.determineStrength());

        LiJiangPassword testForPasswordTen = new LiJiangPassword("hello"); // PasswordFormatException
        System.out.println("Strength for test 10 is: " + testForPasswordTen.determineStrength());

        LiJiangPassword testForPasswordEleven = new LiJiangPassword("abcdefghijk1234987896876!@#!%@!# "); // PasswordFormatException
        System.out.println("Strength for test 11 is: " + testForPasswordEleven.determineStrength());

        LiJiangPassword testForPasswordTwelve = new LiJiangPassword("Password1"); // PasswordFormatException
        System.out.println("Strength for test 12 is: " + testForPasswordTwelve.determineStrength());

        LiJiangPassword testForPasswordThirteen = new LiJiangPassword("password1&"); // PasswordFormatException
        System.out.println("Strength for test 13 is: " + testForPasswordThirteen.determineStrength());

        LiJiangPassword testForPasswordFourteen = new LiJiangPassword("Password&"); // PasswordFormatException
        System.out.println("Strength for test 14 is: " + testForPasswordFourteen.determineStrength());

    }
}