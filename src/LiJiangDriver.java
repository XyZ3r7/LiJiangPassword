public class LiJiangDriver {
    public static void main(String[] args) {
        String password = "Abcde123@";
        LiJiangPassword tester = new LiJiangPassword(password);
        System.out.println(tester.getStrength());
    }
}
