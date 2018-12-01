public class FamousPerson {
    public String givenName;
    public String surname;
    public String quote;

    public FamousPerson(String given, String lastname, String saying) {
        givenName = given;
        surname = lastname;
        quote = saying;
    }

    public void speak() {
        System.out.println("\"" + quote + "\"" + " -" + surname + ", " + givenName);
    }
}