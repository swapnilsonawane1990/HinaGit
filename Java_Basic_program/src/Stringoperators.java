
public class Stringoperators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			   String s1="Sachin";  
			   String s3=new String("Sachin");
			   System.out.println(s1.equals(s3));
			   System.out.println(s1.equalsIgnoreCase(s3));
			   System.out.println(s1.compareTo(s3));
			   String a="meow";
			   String ab=a+"deal";
			   System.out.println(ab);
			   String abc="meowdeal";
			   System.out.println(ab==abc);
			   String arr[]={"meow","moo","bray"};
			   String arr1="meow";
			   System.out.println(arr[0]==arr1);

	}

}
