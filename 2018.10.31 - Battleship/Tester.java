public class Tester {
    public static void main(String[] args) {
        java.util.List<String> bs = FileReadWrite.read("Files/leaderboard.kylebigdumb");

        Object[] bs2 = bs.toArray();

        System.out.println(java.util.Arrays.toString(bs.toArray()));
        java.util.Arrays.sort(bs2);

        System.out.println(java.util.Arrays.toString(bs2));
    }
}