package Day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Day5_Part2 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// Read input
		String s = new String((new FileInputStream("src/Day5/input_day5.txt")).readAllBytes(), StandardCharsets.UTF_8);
		String[] lineSplit = s.split("\n");

		// Set up stacks
		int numberStacks = 9;
		List<Stack<String>> containers = new ArrayList<Stack<String>>();
		IntStream.range(0, numberStacks).forEach(i -> containers.add(new Stack<String>()));
		
		// Read in stacks bottom up
		for(int i = 7; i >= 0; i--) {
			lineSplit[i] += " "; // Add space to make each container regular
			for(int j = 0; j < numberStacks; j++) {	
				int charPos = j*4;
				String subString = lineSplit[i].substring(charPos, charPos+3);
				if(!subString.equals("   ")) containers.get(j).add(subString);
			}
		}
		
		// Print initial set-up
		System.out.println("\nInitial Set-up");
		containers.forEach(System.out::println);
		
		// Move according to schedule
		for(int i = 10; i < lineSplit.length; i++) {
			String[] split = lineSplit[i].split(" ");
			Stack<String> move = new Stack<String>();
			Stack<String> from = containers.get(Integer.valueOf(split[3])-1);
			Stack<String> to = containers.get(Integer.valueOf(split[5])-1);
			for(int j = 0; j < Integer.valueOf(split[1]); j++) {
				move.push(from.peek());
				from.pop();
			}
			while (move.size() != 0) {
	            to.push(move.peek());
	            move.pop();
	        }
	
		}
		
		// Print final result
		System.out.println("\nFinal result");
		containers.forEach(System.out::println);
		
		System.out.println("\nTop elements as String");
		containers.forEach(i -> System.out.print(i.peek().charAt(1))); //PGSQBFLDP
		
//		System.out.println("\nTest stuff");
//		Stack<String> test1 = new Stack<String>();
//		test1.add("1");
//		test1.add("2");
//		
//		test1.forEach(System.out::println);
//		
//		Stack<String> test2 = new Stack<String>();
//		test2.add("3");
//		test2.add("4");
//		
//		test1.addAll(test2);
//		
//		test1.forEach(System.out::println);
		
		
	}

}
