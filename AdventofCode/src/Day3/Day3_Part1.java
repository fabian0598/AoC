package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3_Part1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int score = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day3/input_day3.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				final int mid = line.length() / 2;
				String[] parts = {line.substring(0, mid), line.substring(mid)};
				int length = parts[0].length();
				for(int i = 0; i < length; i++) {
					for(int j = 0; j < length; j++) {
						if(parts[0].charAt(i) == parts[1].charAt(j)) {
							score += convert(parts[0].charAt(i));
							j = length;
							i = length;
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
