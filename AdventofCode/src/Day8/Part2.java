package Day8;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Part2 {

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
		
		int maxScenic = 0;
		
		for(int y = 1; y < yDim - 1; y++) {
			for(int x = 1; x < xDim - 1; x++) {
				
				int scenicScore = 1;
				
				// Check in negative x-Direction
				for(int k = x - 1; k >= 0; k--) {
					
					if(array[k][y] >= array[x][y]) {
						scenicScore *= x - k;
						break;
					}
					
					if(k == 0) {
						scenicScore *= x - k;
					}
				}
				
				// Check in positive x-Direction
				for(int k = x + 1; k <= xDim - 1; k++) {
					
					if(array[k][y] >= array[x][y]) {
						scenicScore *= x - k;
						break;
					}
					
					if(k == xDim - 1) {
						scenicScore *= x - k;
					}
				}
				
				// Check in negative y-Direction
				for(int k = y - 1; k >= 0; k--) {
					
					if(array[x][k] >= array[x][y]) {
						scenicScore *= y - k;
						break;
					}
					
					if(k == 0) {
						scenicScore *= y - k;
					}  
				}
				
				// Check in positive y-Direction
				for(int k = y + 1; k <= yDim - 1; k++) {
					
					if(array[x][k] >= array[x][y]) {
						scenicScore *= y - k;
						break;
					}
					
					if(k == yDim - 1) {
						scenicScore *= y - k;
					} 
				}
				
				if(scenicScore > maxScenic) maxScenic = scenicScore;
				
				
			}
		}
		
		System.out.println(maxScenic);
		
	}


}
