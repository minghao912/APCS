public class Yoda extends FamousPerson {
    private String clause1;
    private String clause2;

    public Yoda(String given, String lastname, String clause1, String clause2) {
        super(given, lastname, null);
        this.clause1 = clause1;
        this.clause2 = clause2;
    }

    public void speak() {
        System.out.println("\"" + clause2 + ", " + Character.toLowerCase(clause1.toCharArray()[0]) + clause1.substring(1) + "\" -Yoda");
    }
}