
public class findwordsinstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String orig="I somewhat   like java";
		String[] aftersplit=orig.trim().split("\\s+");
		System.out.println(orig.trim());
		System.out.println(aftersplit.length);

	}

}
