package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2_Part2_v2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		HashMap<Character, Integer> mapRPS = new HashMap<Character, Integer>();
		int score = 0;
		mapRPS.put('X', 0);
		mapRPS.put('Y', 3);
		mapRPS.put('Z', 6);
		mapRPS.put('A', 1);
		mapRPS.put('B', 2);
		mapRPS.put('C', 3);
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day2/input_day2.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				int scenario = mapRPS.get(line.charAt(2));
				int elf = mapRPS.get(line.charAt(0));
				score += scenario;
				if(scenario == 6) score += (elf % 3) + 1;
				else if (scenario == 3) score += elf;
				else score += ((elf + 1) % 3) + 1;
			}
		}
		System.out.println(score);	
	}

}
