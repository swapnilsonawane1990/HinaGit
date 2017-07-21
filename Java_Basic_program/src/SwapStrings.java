
public class SwapStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Hello";
		String s2="World";
		System.out.println(s1);
		System.out.println(s2);
		int lengths1=s1.length();
		int lengths2=s2.length();
		System.out.println(lengths1);
		System.out.println(lengths2);
		s1=s1+s2;
		System.out.println(s1);
		s2=s1.substring(0,s1.length()-s2.length());
		s1=s1.substring(lengths2);
		System.out.println(s1);
		System.out.println(s2);

	}

}
