package aoc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2_Part1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		HashMap<String, Integer> mapRPS = new HashMap<String, Integer>();
		int score = 0;
		mapRPS.put("X", 1);
		mapRPS.put("Y", 2);
		mapRPS.put("Z", 3);
		mapRPS.put("A", 1);
		mapRPS.put("B", 2);
		mapRPS.put("C", 3);
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/Fabian/eclipse-workspace/FreeTimeTBD/src/aoc/input_day2.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				String[] parts = line.split(" ");
				int elf = mapRPS.get(parts[0]);
				int me = mapRPS.get(parts[1]);
				score += me;
				int temp = me - elf;
				if (temp != -2) score += ((temp + 1) % 3) * 3;
				else score += 6;
			}
		}
		System.out.println(score);
		
	}

}
