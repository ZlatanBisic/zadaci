class Person 
{
	private String firstName;
	private String lastName;
	private String birthday;
	
	private Person () {}
	public Person(String first, String last, String birth) {
		firstName = first;
		lastName = last;
		birthday = birth;		
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public String toString() {
		return firstName + " " + lastName +  " " + birthday; 
	}		
	public static Person getInstance() {
		return new Person();	
	}
	public Person withFirstName (String first) {
		firstName = first;
		return this;
	}
	public Person withLastName (String last) {
		lastName = last;
		return this;
	}
	public Person bornOn (String birth) {
		birthday = birth;
		return this;
	}
}

public class PersonInstTest 
{
	public static void main(String[] args) 
	{
		Person person = Person.getInstance().withFirstName("Adnan").withLastName("Alicic").bornOn("19.03.1987");
		System.out.println(person);
	}
}
