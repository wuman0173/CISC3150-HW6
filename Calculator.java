/* Benjamin Wu
CISC 3150
HW6
Command Line Calculator

Comments: Basic calculator. take in arguments 1,2,3. not on same line.

*/
import java.util.*;

public class Calculator
{
	public static void main(String[] args)
	{
	Scanner scan = new Scanner(System.in);
	double Arg1, Arg3;
	String Arg2;
	System.out.print("Javac Calculator ");
//	try

		Arg1 = scan.nextDouble();
		Arg2 = scan.next();
		Arg3 = scan.nextDouble();	
	System.out.println(Arg1 + Arg3);
	
/*
	catch (NotANumberException ex){
		System.out.println("Not a number.");
		}*/
	}
public class NotANumberException extends Exception
	{
	NotANumberException()
		{
		super();
		}
	NotANumberException(String x)
		{
		super(x);
		}
	}
public static void CheckNumber(double x) throws NotANumberException
	{
	
	}
}
