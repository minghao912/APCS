public class NicholasChan extends FamousPerson{
    public NicholasChan(String given, String lastname, String saying) {
        super(given, lastname, saying);
    }

    public void speak() {
        System.out.println("\"" + quote + " You are a b o t.\"" + " -" + surname + ", " + givenName);
    }
}