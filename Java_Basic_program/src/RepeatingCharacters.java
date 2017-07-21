
public class RepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="I am an engineer";
		int strlength=s1.length();
		int count=0;
		for(int i=0;i<strlength-1;i++)
		{
			if(s1.charAt(i)==s1.charAt(i+1))
			{count=count+1;}
		}
      System.out.println(count);
	}

}
