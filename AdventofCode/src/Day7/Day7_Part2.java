package Day7;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Day7_Part2 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws Exception {

		// Read input
		String s = new String((new FileInputStream("src/Day7/input_day7.txt")).readAllBytes(), StandardCharsets.UTF_8);
		String[] lineSplit = s.split("\n");
		
		
		
		Directory pointer;
		Directory main = new Directory();
		pointer = main;
		ArrayList<Directory> all = new ArrayList<Directory>();
		all.add(main);
		
		// Read input into file system
		for(int i = 1; i < lineSplit.length; i++) {
			
//			System.out.println(i + ": " + pointer.getName());
//			System.out.println(i);
			String[] lineParts = lineSplit[i].split(" ");
			if(lineParts[0].equals("$")) {
				if (lineParts[1].equals("cd")) {
					if(lineParts[2].equals("..")) pointer = pointer.getParent();
					else pointer = pointer.findName(lineParts[2]);
				}
			} else if(lineParts[0].equals("dir")) {
				Directory dirNew = new Directory(lineParts[1], pointer);
				pointer.add(dirNew);
				all.add(dirNew);
			}
			else pointer.addFile(lineParts[1], Integer.valueOf(lineParts[0]));
		}
		
		int minSizeDir = 30000000 - 70000000 + main.getSize();
		Directory smallPoss = main;
		
		for(int i = 0; i < all.size(); i++) {
			//System.out.println(all.get(i).getSize());
			if(all.get(i).getSize() >= minSizeDir && all.get(i).getSize() <= smallPoss.getSize()) {
				//System.out.println(all.get(i).getSize());
				smallPoss = all.get(i);
			}
		}
		
		//System.out.println(all);
		System.out.println(minSizeDir);
		System.out.println(smallPoss.getSize());
		
	}
}
