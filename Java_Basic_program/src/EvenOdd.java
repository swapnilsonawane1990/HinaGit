import java.util.Scanner;


public class EvenOdd {

	/**
	 * @param args
	 */
	public static void main(Stringoperators[] args) {
		// TODO Auto-generated method stub
		int x;
		System.out.println("Enter the no");
		// String input
        //String name = sc.nextLine();
 
        // Character input
        //char gender = sc.next().charAt(0);
		Scanner scanner=new Scanner(System.in);
		x=scanner.nextInt();
				if(x%2==0)
		{
			System.out.println("Even no.");
		}else
		{
			System.out.println("Odd no.");
		}

	}

}
