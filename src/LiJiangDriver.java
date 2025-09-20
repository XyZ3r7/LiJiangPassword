public class LiJiangDriver {
    public static void main(String[] args) {
        String password = "abcdefghijk1234987896876!@#!%@!#";
        LiJiangPassword tester = new LiJiangPassword(password);
        System.out.println(tester.getStrength());
    }
}
