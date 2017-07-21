
public class seriesprog3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*  1 
		2 1 
		3 2 1 
		4 3 2 1 
		5 4 3 2 1 
		6 5 4 3 2 1*/
		int c=1;
		for (int i=1;i<=4;i++){
	    	   for(int j=1;j<i+1;j++)
	    	   {    
	    		   System.out.print(c+"\t");
	    		   c++;
	    	   }
	    	   System.out.println("");
	    	   
	       }


	}

}
