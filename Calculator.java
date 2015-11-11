/* Benjamin Wu
CISC 3150
HW6
Command Line Calculator

Comments: Basic calculator. take in arguments 1,2,3. Works on Same Line if using Spaces since Java automatically uses them as tokens.

*/
import java.util.*;

public class Calculator
{
	public static void main(String[] args)
	{
	Scanner scan = new Scanner(System.in);
	String operator;
	double number1, number2;
	System.out.println("wuman's Javac Calculator, to work, please type in any basic math problem, like 1 + 1. Please put one space after the first number and math operator. Like 1 + 1. NOT 1+1");
	System.out.print("Javac Calculator ");
	Calculator calc = new Calculator();
/*
	if (scan.hasNextDouble())
		{
		number1 = scan.nextDouble();	//works when input is on a single line
		}
	else throw new NotANumberException("Not a Number.");

	operator = scan.next();		//As long as there is a space between each Arg
	
	if(scan.hasNextDouble())
		{
		number2 = scan.nextDouble();		//Without Pressing Enter
		}
	else throw new NotANumberException("Not a Number.");
*/
	try
	{
		number1 = calc.checkNumbers(scan);
		operator = calc.checkOperator(scan);
		number2 = calc.checkNumbers(scan);
		System.out.println(number1 + " " + operator + " " + number2); //Test
	}
	catch (NotANumberException ex)
		{
		System.out.println(ex);
		}
	catch (IllegalOperationException ex)
		{
		System.out.println(ex);
		}
	catch (NotEnoughNumbersException ex)
		{
		System.out.println(ex);
		}
	}
public class NotANumberException extends IllegalArgumentException
	{
	NotANumberException(String x)
		{
		super(x);
		}
	}
public class IllegalOperationException extends IllegalArgumentException
	{
	IllegalOperationException(String x)
		{
		super(x);
		}
	}
public class NotEnoughNumbersException extends IllegalArgumentException
	{
	NotEnoughNumbersException(String x)
		{
		super(x);
		}
	}

public double checkNumbers(Scanner scan) //Number checker, as said.
	{
 	double checker = 0;
	if (scan.hasNextDouble())
		{
		checker = scan.nextDouble();
		return checker;
		}
	else
		throw new NotANumberException("OMG! You didn't put in a Number, do eet again.");
	}
public String checkOperator(Scanner scan) //method that checks operator. uses strings, tried char, no work, too complicate, cant change string to char, so stuck with string. yep.
	{
	String checkOp = scan.next();
	if ((checkOp.equals("/")) || (checkOp.equals("*")) || (checkOp.equals("+")) || (checkOp.equals("-")) || (checkOp.equals("%")))
		{
		return checkOp;
		}
	else
		throw new IllegalOperationException("You baddie. Wrong Math Operator. Use +, -, /, *, or %");
	}
}
