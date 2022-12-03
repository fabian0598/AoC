package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3_Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int score = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day3/input_day3.txt"))) {
			String line1, line2, line3;
			while((line1 = br.readLine()) != null 
					&& (line2 = br.readLine()) != null
					&& (line3 = br.readLine()) != null)
			{
				for(int i = 0; i < line1.length(); i++) {
					for(int j = 0; j < line2.length(); j++) {
						for(int k = 0; k < line3.length(); k++) {
							if((line1.charAt(i) == line2.charAt(j)) && (line1.charAt(i) == line3.charAt(k))) {
								score += convert(line1.charAt(i));
								i = j = k = 200;
							}
						}
					}
				}
			}
			System.out.println(score);	
		}
	}

	public static int convert(char x) {
		if(x < 92) return x - 38;
		else return x - 96;
	}

}
