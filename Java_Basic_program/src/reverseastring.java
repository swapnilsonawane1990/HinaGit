
public class reverseastring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="Hina Garg";
		String reversedstring="";
		int length=x.length();
		for(int i=length-1;i>=0;i--)
		{
			reversedstring=reversedstring+x.charAt(i); 
		}
		System.out.println(reversedstring);

	}

}
