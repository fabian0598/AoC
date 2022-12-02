package leetcode;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}
	
	public static List<String> letterCombinations(String digits) {
		List<List<String>> combinations = new ArrayList<>();
		for (int i = 0; i < digits.length(); i++) {combinations.add(mapping(Character.getNumericValue(digits.charAt(i))));}
		return recursivComb(combinations, Arrays.asList(new String[]{}));
	}

	public static List<String> recursivComb(List<List<String>> input, List<String> output) {
		List<String> output2 = new ArrayList<>(); 
		if (output.size() == 0) {
			output2 = input.get(0);
			input.remove(0);
		} else {
			for (String i: input.get(0)) {	
				for (String j: output) {
					output2.add(j+i);
				}
			}
			input.remove(0);
		}
		if(input.size() > 0) {
			output2 = recursivComb(input, output2);
		}
		return output2;
	}

	public static List<String> mapping(int number) {
		switch(number){
		case 2: return Arrays.asList(new String[]{"a","b","c"});
		case 3: return Arrays.asList(new String[]{"d","e","f"});
		case 4: return Arrays.asList(new String[]{"g","h","i"});
		case 5: return Arrays.asList(new String[]{"j","k","l"});
		case 6: return Arrays.asList(new String[]{"m","n","o"});
		case 7: return Arrays.asList(new String[]{"p","q","r","s"});
		case 8: return Arrays.asList(new String[]{"t","u","v"});
		case 9: return Arrays.asList(new String[]{"w","x","y","z"});
		default: return Arrays.asList(new String[]{});
		}       
	}
}