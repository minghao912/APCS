public class Elizabethan extends FamousPerson{
    public Elizabethan(String given, String lastname, String saying) {
        super(given, lastname, saying);
    }

    public void speak() {
        String comma = ",";
        if ((quote.substring(quote.length() - 1)).matches("[.,?!:;]")) comma = "";

        System.out.println("\"" + quote + comma + "\" quoth " + givenName + " " + surname);
    }
}