
public class PallindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="12321";
		String result="";
		int length=x.length();
		for  (int i=length-1;i>=0;i--){
			result=result+x.charAt(i);
			
		}
		System.out.println(result);

	
	if(x.equalsIgnoreCase(result))
	{System.out.println("Number is Pallindrome");
	}
	else
	{
		System.out.println("Number is not Pallindrome");
	}

}}
