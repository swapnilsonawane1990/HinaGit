
public class seriesprog2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*  1
		1 0
		1 0 1
		1 0 1 0
		1 0 1 0 1 */
		int A=1,B=1;
		
			System.out.println(A);
			for (int i=1;i<5;i++)
			{   if(i%2!=0)
			{
			A=A*10;
			System.out.println(A);}
			else
			{
				A=B+A*10;
				System.out.println(A);
			}
		}		
			
			
	}

}

