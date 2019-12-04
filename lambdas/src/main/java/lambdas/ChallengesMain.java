package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ChallengesMain {

	public static void main(String[] args) {
		modifyNamesStreams();
		//modifyNames();
		//iLoveJava();
		//everySecondChar2("1234567890");
		//splitString2();
	}	
	
	
	public static void modifyNamesStreams()
	{
		List<String> topNames2015 = Arrays.asList("Amelia",
				"Olivia",
				"emily",
				"Isla",
				"Ava",
				"oliver",
				"Jack",
				"Charlie",
				"harry",
				"Jacob");		
		
		topNames2015.stream()
		.map(s -> s.substring(0, 1).toUpperCase() + s.substring(1, s.length()))
		.sorted(String::compareTo)
		.filter(s -> s.startsWith("A"))
		.forEach(System.out::println);
		
	}
	
	public static void modifyNames()
	{
		List<String> topNames2015 = Arrays.asList("Amelia",
				"Olivia",
				"emily",
				"Isla",
				"Ava",
				"oliver",
				"Jack",
				"Charlie",
				"harry",
				"Jacob");
		
		
		List<String> result = new ArrayList<>();
		topNames2015.forEach(s -> result.add(s.substring(0, 1).toUpperCase() + s.substring(1, s.length())));
		//result.sort((s1,s2)->s1.compareTo(s2));		
		result.sort(String::compareTo);		
		result.forEach(System.out::println);
	
	}
	
	
	public static void iLoveJava()
	{
		Supplier<String> mySupplier = () -> "I love Java!";
		String iLoveJava = mySupplier.get();
		System.out.println(iLoveJava);
	}
	
	public static void everySecondChar2(String inputStr)
	{
		Function<String, String> myFunction = s -> {
			StringBuilder returnValue = new StringBuilder();
			for(int i=0; i < s.length() ;i++)
			{
				if(i%2 == 1)
					returnValue.append(s.charAt(i));
			}
			return returnValue.toString();
		};			
		System.out.println(applyStringFunction(inputStr, myFunction));
	}
	
	public static String applyStringFunction(String myString, Function<String,String> myFunction)
	{
		return myFunction.apply(myString).toString();
	}
	
	public static void everySecondChar()
	{
		Function<String, StringBuilder> myFunction = s -> {
			StringBuilder returnValue = new StringBuilder();
			for(int i=0; i < s.length() ;i++)
			{
				if(i%2 == 1)
					returnValue.append(s.charAt(i));
			}
			return returnValue;
		};
		
		
		System.out.println(myFunction.apply("1234567890"));
	}
	
	
	public static void splitString()
	{
		
		Runnable runnable = ()->{
			String myString = "Let's split this into an array";
			Arrays.stream(myString.split(" ")).forEach(System.out::print);
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	public static void splitString2()
	{
		Consumer<String> printerFunction = s -> Arrays.stream(s.split(" ")).forEach(System.out::print);
		String myString = "Let's split this into an array";
		Thread thread = new Thread(() -> printerFunction.accept(myString));
		thread.start();
	}

}
