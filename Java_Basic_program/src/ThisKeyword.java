
public class ThisKeyword {

	/**
	 * @param args
	 */
	int a,b;
	void func()
	{
		System.out.println("This is function");
	}
//	ThisKeyword()
//	{ this(30,40);}
	ThisKeyword(int a,int b)
	{   this.func();
		this.a=a;
		this.b=b;
		System.out.println("a="+a+" "+"b="+b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThisKeyword obj=new ThisKeyword(10,20);
		
	}

}
