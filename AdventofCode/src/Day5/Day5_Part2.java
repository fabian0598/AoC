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
		List<Stack<String>> containers = new ArrayList<Stack<String>>();
		IntStream.range(0, 9).forEach(i -> containers.add(new Stack<String>()));
		
		for(int i = 7; i >= 0; i--) {
			int j = 0;
			int k = 0;
			lineSplit[i] += " "; // Add space to make each container regular
			while(j < lineSplit[i].length()) {	
				String subString = lineSplit[i].substring(j, j+3);
				j += 4;
				if(!subString.equals("   ")) containers.get(k).add(subString);
				k++;
			}
		}
		
		containers.forEach(System.out::println);
		System.out.println("\n");
		
		for(int i = 10; i < lineSplit.length; i++) {
			String[] split = lineSplit[i].split(" ");
			Stack<String> temp = new Stack<String>();
			Stack<String> from = containers.get(Integer.valueOf(split[3])-1);
			Stack<String> to = containers.get(Integer.valueOf(split[5])-1);
			for(int j = 0; j < Integer.valueOf(split[1]); j++) {
				temp.push(from.peek());
				from.pop();
			}
			while (temp.size() != 0) {
	            to.push(temp.peek());
	            temp.pop();
	        }
		}
		
		containers.forEach(System.out::println);
		containers.forEach(i -> System.out.print(i.peek().charAt(1)));
	}

}
