package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2_Part2_v2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		HashMap<String, Integer> mapRPS = new HashMap<String, Integer>();
		int score = 0;
		mapRPS.put("X", 0);
		mapRPS.put("Y", 3);
		mapRPS.put("Z", 6);
		mapRPS.put("A", 1);
		mapRPS.put("B", 2);
		mapRPS.put("C", 3);
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/Fabian/eclipse-workspace/FreeTimeTBD/src/aoc/input_day2.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				String[] parts = line.split(" ");
				int scenario = mapRPS.get(parts[1]);
				score += scenario;
				if(scenario == 6) score += (mapRPS.get(parts[0])%3)+1;
				else if (scenario == 3) score += mapRPS.get(parts[0]);
				else score += ((mapRPS.get(parts[0])+1)%3)+1;
			}
		}
		System.out.println(score);	
	}

}
