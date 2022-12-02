package aoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1_Part1_v2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/Fabian/eclipse-workspace/FreeTimeTBD/src/aoc/input_day1.txt"))) {
		    int maxValue = 0;
		    int currentValue = 0;
			for(String line; (line = br.readLine()) != null; ) {
		        if (line.trim().isEmpty()) {
		        	if (currentValue > maxValue) maxValue = currentValue;
		        	currentValue = 0;
		        } else currentValue += Integer.valueOf(line);
		    }
			if (currentValue > maxValue) maxValue = currentValue;
			System.out.println(maxValue);
		}
	}

}
