public class LiJiangPasswordDriver {
    public static void main(String[] args) {

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

//         // Examples iii
//         LiJiangPassword iii_1 = new LiJiangPassword("abc123&");
//         LiJiangPassword sdlkfj = new LiJiangPassword("abacabadabacabae");
//         System.out.println(sdlkfj.extraOccurrence());
    }
}
