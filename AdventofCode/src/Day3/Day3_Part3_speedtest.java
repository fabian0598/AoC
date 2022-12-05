package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day3_Part3_speedtest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int score = 0;
		Integer count = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day3/input_day3.txt"))) {
			String line1, line2, line3;
			while((line1 = br.readLine()) != null && (line2 = br.readLine()) != null && (line3 = br.readLine()) != null)
			{
				List<String> lines = Arrays.asList(line1, line2, line3);
				
				Collections.sort(lines, Comparator.comparing(String::length)); // Sort
				Collections.reverse(lines); // Reverse
				
				// Drop first and attach at the end again
//				String buffer = lines.get(0);
//				lines.remove(0);
//				lines.add(buffer);
				
				
				// Shuffle
//				Collections.shuffle(lines);
				
				// Length print
//				for (String i: lines) System.out.println(i.length());
				
				for(int i = 0; i < lines.get(0).length(); i++) {
					for(int j = 0; j < lines.get(1).length(); j++) {
						for(int k = 0; k < lines.get(2).length(); k++) {
							if((lines.get(0).charAt(i) == lines.get(1).charAt(j)) && (lines.get(0).charAt(i) == lines.get(2).charAt(k))) {
								score += convert(lines.get(0).charAt(i));
								i = j = k = 200;
							}
							count++;
						}
					}
				}
			}
			System.out.println(score);	
			System.out.println(count);	
		}
	}

	public static int convert(char x) {
		if(x < 92) return x - 38;
		else return x - 96;
	}

}
