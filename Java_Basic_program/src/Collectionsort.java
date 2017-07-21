import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Collectionsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<String>();  
		al.add("Viru");  
		al.add("Saurav");  
		al.add("Mukesh");  
		al.add("Tahir");  
		System.out.println(al);  
		Collections.sort(al); 
		System.out.println(al); 
		Iterator<String> itr=al.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		 }  

	}

}
