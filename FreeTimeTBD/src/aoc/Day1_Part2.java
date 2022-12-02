package aoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1_Part2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/Fabian/eclipse-workspace/FreeTimeTBD/src/aoc/input_day1.txt"))) {
			int maxValue1, maxValue2, maxValue3, currentValue;
			maxValue1 = maxValue2 = maxValue3 = currentValue = 0;
			for(String line; (line = br.readLine()) != null; ) {
				if (line.trim().isEmpty()) {
					if (currentValue > maxValue1) {
						maxValue3 = maxValue2;
						maxValue2 = maxValue1;
						maxValue1 = currentValue;
					} else if (currentValue > maxValue2) {
						maxValue2 = currentValue;
						maxValue3 = maxValue2;
					} else if (currentValue > maxValue3) {
						maxValue3 = currentValue;
					}
					currentValue = 0;
				} else {
					currentValue += Integer.valueOf(line);
				}
			}
			if (currentValue > maxValue1) {
				maxValue3 = maxValue2;
				maxValue2 = maxValue1;
				maxValue1 = currentValue;
			} else if (currentValue > maxValue2) {
				maxValue2 = currentValue;
				maxValue3 = maxValue2;
			} else if (currentValue > maxValue3) {
				maxValue3 = currentValue;
			}
			System.out.println(maxValue1 + " " + maxValue2 + " " + maxValue3);
			System.out.println(maxValue1 + maxValue2 + maxValue3);
		}
	}

}
