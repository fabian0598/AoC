package Day8;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws Exception {

		// Read input
		String s = new String((new FileInputStream("src/Day8/input.txt")).readAllBytes(), StandardCharsets.UTF_8);
		String[] lineSplit = s.split("\n");
		int xDim = lineSplit[0].length();
		int yDim = lineSplit.length;
		int[][] array = new int[xDim][yDim];
		int count = xDim * 2 + yDim * 2 - 4;
		System.out.println(count);
		
		// Read input into file system
		for(int i = 0; i < yDim; i++) {
			String[] line = lineSplit[i].split("");
			for(int j = 0; j < xDim; j++) {
				array[j][i] = Integer.valueOf(line[j]);
			}
		}
		
		for(int y = 1; y < yDim - 1; y++) {
			for(int x = 1; x < xDim - 1; x++) {
				
				
				//System.out.println("xDim: " + j + " yDim: "+i);
				boolean seen = false;
				
				// Check in negative x-Direction
				for(int k = x - 1; k >= 0; k--) {
					
					if(array[k][y] >= array[x][y]) {
						break;
					}
					
					if(!seen && k == 0) {
						System.out.println("-x: xDim: " + x + " yDim: "+ y);
						seen = true;
						count++;
					}
				}
				
				// Check in positive x-Direction
				for(int k = x + 1; k <= xDim - 1; k++) {
					
					if(array[k][y] >= array[x][y]) {
						break;
					}
					
					if(!seen && k == xDim - 1) {
						System.out.println("+x: xDim: " + x + " yDim: "+ y);
						seen = true;
						count++;
					}
				}
				
				// Check in negative y-Direction
				for(int k = y - 1; k >= 0; k--) {
					
					if(array[x][k] >= array[x][y]) {
						break;
					}
					
					if(!seen && k == 0) {
						System.out.println("-y: xDim: " + x + " yDim: "+ y);
						seen = true;
						count++;
					}  
				}
				
				// Check in positive y-Direction
				for(int k = y + 1; k <= yDim - 1; k++) {
					
					if(array[x][k] >= array[x][y]) {
						break;
					}
					
					if(!seen && k == yDim - 1) {
						System.out.println("+y: xDim: " + x + " yDim: "+ y);
						seen = true;
						count++;
					} 
				}
				
				
			}
		}
		
		System.out.println(count);
		
	}


}
