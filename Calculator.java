/* Benjamin Wu
CISC 3150
HW6
Command Line Calculator

Comments: Basic calculator. take in arguments 1,2,3. Works on Same Line if using Spaces since Java automatically uses them as tokens. 
But this doesn't allow me to create the NotEnoughNumbersException to appear, since scan is waiting for a third argument, 
Was trying to set an if statement to see if the argument (or delimiter?) is blank or a space, doesn't seem to trigger the exception. How to make that happen? 

Also trying to use Patterns since Scanner has that for delims, Matchers, in the regex class, using "/s" as a whitespace trigger, didn't work... etc.

was looking at 
http://stackoverflow.com/questions/7320315/how-to-test-for-blank-line-with-java-scanner
to see, but people say it doesn't work on the same line, but still haven't even trip the if statement let alone have it work on the same arg line.

Was lazy, did not overload methods so it could do  integer arithmitic if ints were teh inputs. 
=[

*/
import java.util.*;

public class Calculator
{
	public static void main(String[] args)
	{
	Scanner scan = new Scanner(System.in);
	String operator;
	double number1, number2, finalnumbah = 0;
	System.out.print("Javac Calculator ");
	Calculator calc = new Calculator();

	try
	{
		number1 = calc.checkNumbers(scan);
		operator = calc.checkOperator(scan);
		number2 = calc.checkSecondNumber(scan);
//		System.out.println(number1 + " " + operator + " " + number2); //Test
		
		if (operator.equals("+"))
			finalnumbah = calc.add(number1, number2);
		else if (operator.equals("-"))
			finalnumbah = calc.subtract(number1, number2);
		else if (operator.equals("*"))
			finalnumbah = calc.multiply(number1, number2);
		else if (operator.equals("/"))
			finalnumbah = calc.divide(number1, number2);
		else if (operator.equals("%"))
			finalnumbah = calc.remainder(number1, number2);
		else
			System.out.println("Something went horribly wrong here!"); //test final else statement if anything goes wrong.
		System.out.println(finalnumbah);
		
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
	catch (ArithmiticException ex)
		{
		System.out.println(ex);
		}
	}
/***********************
 *EXCEPTION CLASSES YEH*
 ***********************/
public class NotANumberException extends IllegalArgumentException //Exception Classes. Don't have default constructor since not using it to call. cuz throwing it with my personal string lels.
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
public class ArithmiticException extends IllegalArgumentException
	{
	ArithmiticException(String x)
		{
		super(x);
		}
	}

/****************
 ** METHODS YH **
 ****************/
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
public double checkSecondNumber(Scanner scan)
	{
	double checker = 0;
	if (scan.hasNextDouble())
		{
		checker = scan.nextDouble();
		return checker;
		}
	else 		//Problems with this else statement. Cannot do if(scan.next()equals(), A LOT OF STUFF TRIED. Cant seem to get the not enough numbers exception to appear.
		{
		throw new NotEnoughNumbersException("WTF not enough numbers!");
		}
	/*
	else if (!scan.hasNextDouble())
		{
		throw new NotANumberException("Yo ur 2nd numbah aint a numbah")
		}
	
	else 
		System.out.println("Something went wrong and I don't know what, but have a ZERO instead!");
		return 0;
	*/
	}
public double add(double number1, double number2)
	{
	double number3 = 0;
	number3 = number1 + number2;
	return number3;
	}
public double subtract(double number1, double number2)
	{
	double number3 = 0;
	number3 = number1 - number2;
	return number3;
	}
public double multiply(double number1, double number2)
	{
	double number3 = 0;
	number3 = number1*number2;
	return number3;
	}
public double divide(double number1, double number2)
	{
	double number3 = 0;
	if (number2 == 0)
		throw new ArithmiticException("DIVIDING BY ZERO IS BAD");
	else
		{
		number3 = number1/number2;
		return number3;
		}	
	}
public double remainder(double number1, double number2)
	{
	double number3 = 0;
	number3 = number1%number2;
	return number3;
	}
}
