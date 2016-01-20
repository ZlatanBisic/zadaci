class MyDuoClass 
{
	private static MyDuoClass instance1 = null, instance2 = null;
	private MyDuoClass () {}
	public static MyDuoClass getInstance() 
	{
		if (instance1 == null && instance2 == null)
		{
			instance1 = new MyDuoClass();
			return instance1;
		}
		else if (instance2==null)
		{
			instance2 = new MyDuoClass();
			return instance2;
		}
		return null;	// or we can return one of the real instances (instance1 or instance2)
	}
}

public class MyDuoClassTest 
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
