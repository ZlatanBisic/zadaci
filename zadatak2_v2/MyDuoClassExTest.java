class MyDuoClass 
{
	private static class Duo extends MyDuoClass 
	{
		private static  MyDuoClass instance1 = null, instance2 = null;
		private Duo () {}
		public String toString() 
		{
			return "\n\tInst1: " + instance1 + "\n\tInst2: " + instance2;			
		}
	} 
	private  MyDuoClass () {}
	
	public static MyDuoClass getInstance() 
	{
		Duo duo = new Duo();
		if (Duo.instance1 == null && Duo.instance2 == null)
		{
			Duo.instance1 = new MyDuoClass();
			return Duo.instance1;
		}
		else if (Duo.instance2==null)
		{
			Duo.instance2 = new MyDuoClass();
			return Duo.instance2;
		}
		return duo;
	}
}

public class MyDuoClassExTest 
{
 	public static void main(String[] args)
 	{
 		MyDuoClass one =  MyDuoClass.getInstance();
 		System.out.println("One: " + one);
 		MyDuoClass two =  MyDuoClass.getInstance();
 		System.out.println("Two: " + two);
 		MyDuoClass three =  MyDuoClass.getInstance();
 		System.out.println("Three: " + three);
 		MyDuoClass four =  MyDuoClass.getInstance();
 		System.out.println("Four: " + four);
 		MyDuoClass five =  MyDuoClass.getInstance();
 		System.out.println("Five: " + five);
   }
}
