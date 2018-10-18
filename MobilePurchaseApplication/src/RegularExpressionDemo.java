import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpressionDemo {

	
	public static void main(String[] args) {
	
		Scanner sc= new Scanner(System.in);
		Pattern pattern= Pattern.compile("[A-Z][a-z]{4,}");
	
		System.out.println("Enter Your Name ");
		String str= sc.next();
		
		Matcher matcher= pattern.matcher(str);
		if(matcher.matches())
			System.out.println("valid input");
		else
			System.out.println("invalid input..");
	
	}
}
