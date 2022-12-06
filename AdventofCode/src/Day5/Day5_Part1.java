package Day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Day5_Part1 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// Read input, first day in which I am not using a buffered reader
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
			Stack<String> from = containers.get(Integer.valueOf(split[3])-1); // Find container from which boxes will be unloaded, -1 because transposing 1-9 to 0-8 (Java indexes)
			Stack<String> to = containers.get(Integer.valueOf(split[5])-1); // Find container to which boxes will be unloaded, -1 because transposing 1-9 to 0-8 (Java indexes)
			for(int j = 0; j < Integer.valueOf(split[1]); j++) to.push(from.pop());
		}
		
		// Print final result
		System.out.println("\nFinal result");
		containers.forEach(System.out::println);
		
		System.out.println("\nTop elements as String");
		containers.forEach(i -> System.out.print(i.peek().charAt(1))); // BSDMQFLSP
	}

}
