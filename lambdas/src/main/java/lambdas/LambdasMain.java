package lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdasMain {
	
	
	// Sort example with Collections
	/*public static void main(String[] args) {

		
		Thread thread = new Thread(()->{
			
			Person mike = new Person("mike", 25);
			Person paul = new Person("paul", 32);
			
			List<Person> people = new ArrayList<>();
			
			people.add(mike);
			people.add(paul);
			
			//Collections.sort(people, (a,b)->a.getName().compareTo(b.getName()));
			people.sort((a,b)->a.getName().compareTo(b.getName()));
			
		});
		
		thread.start();
		
		
	}*/


	public static void main(String[] args) {
		
		Person mike = new Person("mike", 25);
		Person paul = new Person("paul", 32);
		
		List<Person> people = new ArrayList<>();
		
		people.add(mike);
		people.add(paul);

		people.forEach((p)->{
			System.out.println(p.getName());
		});		
		
	}


}
