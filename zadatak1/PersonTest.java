import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Person 
{
	private String firstName;
	private String lastName;
	private String birthday;
	
	public Person(String first, String last, String birth) {
		firstName = first;
		lastName = last;
		birthday = birth;						
	}
	public String getBirthday() {
		return birthday;
	}
	public String toString(){
		return firstName + " " + lastName +  " " + birthday; 
	}			
}

abstract class MySorter 
{
	public static void sortByBirthday(List<Person> list)
	{
		 Collections.sort(list, bComparator);
		 for (int i=0; i<list.size(); i++)
			 System.out.println(i+1 + ". " + list.get(i).toString());
	}
	private static Comparator<Person> bComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) 
		{
			Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
			c1.set(Integer.parseInt(p1.getBirthday().substring(6, 10)), 
					Integer.parseInt(p1.getBirthday().substring(3, 5)), 
					Integer.parseInt(p1.getBirthday().substring(0, 2)));
			
			c2.set(Integer.parseInt(p2.getBirthday().substring(6, 10)), 
					Integer.parseInt(p2.getBirthday().substring(3, 5)), 
					Integer.parseInt(p2.getBirthday().substring(0, 2)));
	
		   return c1.compareTo(c2);
		}
	};
}

public class PersonTest 
{
	public static void main(String[] args) 
	{
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Adnan", "Alicic", "19.03.1987"));
		persons.add(new Person("Amir", "Trajanakovski", "29.04.1978"));
		persons.add(new Person("Denis", "Delic", "01.01.2000"));
		MySorter.sortByBirthday(persons);
	}
}
