//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab14i
{
	public static void main( String args[] )
	{
		RomanNumeral test = new RomanNumeral(10);
		out.println("10 is " + test.toString());

		test.setNumber(100);
		out.println("100 is " + test.toString());

		test.setNumber(1000);
		out.println("1000 is " + test.toString());

		test.setNumber(2500);
		out.println("2500 is " + test.toString());

		test = new RomanNumeral(1500);
		out.println("1500 is " + test.toString());

		test.setNumber(23);
		out.println("23 is " + test.toString());

		test.setNumber(38);
		out.println("38 is " + test.toString());

		test.setNumber(49);
		out.println("49 is " + test.toString());

		test.setRoman("LXXVII");
		out.println("LXXVII is " + test.getNumber() + "\n");

		test.setRoman("XLIX");
		out.println("XLIX is " + test.getNumber() + "\n");

		test.setRoman("XX");
		out.println("XX is " + test.getNumber() + "\n");

		test.setRoman("XLIX");
		out.println("XLIX is " + test.getNumber() + "\n");
	}
}