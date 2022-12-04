package Day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day4_Part2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		int score = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("src/Day4/input_day4.txt"))) {
			for(String line; (line = br.readLine()) != null; ) {
				String[] parts = line.split(",");
				String[] ass1 = parts[0].split("-");
				String[] ass2 = parts[1].split("-");
				//System.out.println(ass2[0]+ass1[0]+ass2[1]+ass1[1]);
				if(Integer.valueOf(ass1[1])>=Integer.valueOf(ass2[0])&&Integer.valueOf(ass1[0])<=Integer.valueOf(ass2[0])) {
					score += 1;
				} else if(Integer.valueOf(ass2[1])>=Integer.valueOf(ass1[0])&&Integer.valueOf(ass2[0])<=Integer.valueOf(ass1[0])) {
					score += 1;
				}
			}
		}
		System.out.println(score);
	}

}
