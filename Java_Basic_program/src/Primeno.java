import java.util.Scanner;


public class Primeno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter the no");
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		//int num=17;
		int a=num/2;
		if(a%2==0)
		{
			System.out.println("Number is not prime");
		
		}
		else
	{System.out.println("Number is prime");}

	}

}
