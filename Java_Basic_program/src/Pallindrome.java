import java.util.Scanner;


public class Pallindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String name="HINA";
		Scanner scanner=new Scanner(System.in);
		String x=scanner.next();
		String result="";
		int length=x.length();
		System.out.println(length);
		for (int i=length-1;i>=0;i--)
		{
			result=result+x.charAt(i);
			
		}
		System.out.print(result);
	}

}
