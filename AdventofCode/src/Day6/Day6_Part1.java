package Day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Day6_Part1 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Read input, first day in which I am not using a buffered reader
		String s = new String((new FileInputStream("src/Day6/input_day6.txt")).readAllBytes(), StandardCharsets.UTF_8);
		int length = 4;
		
		for(int i = 0; true; i++) {
			if(hasAllUniqueChars(s.substring(i, i + length))) {
				System.out.println(i + length); // 1275
				break;
			}
		}
	}

	public static boolean hasAllUniqueChars(String word) {
		HashSet<Character> set = new HashSet<Character>();
		for(int index = 0; index < word.length(); index++)   {
			char c = word.charAt(index);
			// If Hashset's add method return false,that means it is already present in HashSet
			if(!set.add(c)) return false;
		}
		return true;
	}
}
