
public class Fibonacciseries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0 1 1 2 3 5 8 13 21 34
		int x=0,y=1,z;
		System.out.print(x+" "+y);
		for (int i=0;i<10;++i){
			
			z=x+y;
			System.out.print(" "+z);
			x=y;
			y=z;
			
		}

	}

}
