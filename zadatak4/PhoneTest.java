interface Phone
{
	public void call();
	public void call(int n);
}

class MobilePhone implements Phone
{
	public void call ()
	{
		System.out.println("Calling from mobile phone");
	}
	public void call (int n) 
	{ 
		System.out.println("Calling number " + n + " from mobile phone");
	}
}

class Iphone extends MobilePhone implements Phone
{
	public void call ()
	{
		System.out.println("Calling from iPhone");
	}
	public void call (int n)
	{
		System.out.println("Calling number " + n + " from iPhone");
	}
}

public class PhoneTest 
{
	public static void main(String[] args) 
	{
		Phone p = new Iphone();
		p.call();
		MobilePhone mp = new MobilePhone();
		mp.call();
		MobilePhone  mpi = new Iphone();
		mpi.call();
		mpi.call(1212121221);
	}
}
