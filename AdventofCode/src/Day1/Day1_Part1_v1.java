package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1_Part1_v1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/Fabian/eclipse-workspace/FreeTimeTBD/src/aoc/input_day1.txt"))) {
		    int pointer = 0;
		    int maxElf = 0;
		    int maxValue = 0;
		    int currentValue = 0;
			for(String line; (line = br.readLine()) != null; ) {
		        if (line.trim().isEmpty()) {
		        	if (currentValue > maxValue) {
		        		maxValue = currentValue;
		        		maxElf = pointer;
		        	}
		        	pointer += 1;
		        	currentValue = 0;
		        } else {
		        	currentValue += Integer.valueOf(line);
		        }
//				System.out.println(maxElf);
		    }
			if (currentValue > maxValue) {
        		maxValue = currentValue;
        		maxElf = pointer;
        	}
			System.out.println(maxValue);
		    // line is not visible here.
		}
	}

}
