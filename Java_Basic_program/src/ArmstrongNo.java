import java.util.Scanner;


public class ArmstrongNo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c=0,a,temp;
		//int n=153;
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		temp=n;
		while(n>0)
		{    a=n%10;
		System.out.println(a);
		n=n/10;
		System.out.println(n);
			c=c+a*a*a;
			System.out.println(c);
		}
		if(temp==c)
		{System.out.println("Armstrong no.");}
		else
		{System.out.println("Not an Armstrong no.");}	

	}

}
