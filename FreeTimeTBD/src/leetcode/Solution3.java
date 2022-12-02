package leetcode;

class Solution3 {
	public static void main(String[] args) {
		int[] height = {4,2,3};
		System.out.print(trap(height));
	}
	
    public static int trap(int[] height) {
        int area1 = 0;
        int area2 = 0;
        int width = height.length;
        for (int value : height) {
            area1 += value;
        }
        for (int i = 0; i < width - 1; i++) {
            if (height[i] != 0){
                int j = i + 1;
                while (height[j] < height[i]){
                    j++;
                    if(j==width){
                    	area2++;
                    	height[i]--;
                    	j = i + 1;
                    }
                }
                if (j != width){
                	System.out.println("J: " + j);
                	System.out.println("I: " + i);
                	System.out.println("Height: " + height[i]);
                    area2 += (j - i) * height[i];
                    i = j - 1;
                } else {
                	area2 += height[i];
                }
            }
        }
        area2 += height[width-1];
        System.out.println(area2);
        System.out.println(area1);
        return area2 - area1;
    }
}