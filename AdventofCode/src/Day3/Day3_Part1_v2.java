package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3_Part1_v2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int score = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day3/input_day3.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				final int mid = line.length() / 2;
				for(int i = 0; i < mid; i++) {
					for(int j = 0; j < mid; j++) {
						if(line.charAt(i) == line.charAt(j+mid)) {
							score += convert(line.charAt(i));
							j = i = mid;
						}
					}
				}
			}
		}
		System.out.println(score);	
	}
	
	public static int convert(char x) {
		if(x < 92) return x - 38;
		else return x - 96;
	}

}
