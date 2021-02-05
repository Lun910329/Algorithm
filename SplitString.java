

import java.util.ArrayList;
import java.util.List;

public class SplitString {
	
	public List<String> splitBychar(String s, char c) {
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			StringBuilder sb = new StringBuilder();
			while (i < s.length() && s.charAt(i) != c) {
				sb.append(s.charAt(i));
				i++;
			}
			result.add(sb.toString());
			i++;
		}
		return result;
	}
	
	public List<String> splitByString(String s, String t) {
		List<String> result = new ArrayList<>();
		int n = t.length();
		int m = s.length();
		int i = 0, j = n;
		
		while (i < m - n  && j < m ) {
			StringBuilder sb = new StringBuilder();
			while (i < m - n  && j < m  && !s.substring(i, j).equals(t)) {
				sb.append(s.charAt(i));
				i++;
				j++;
				
				if (i >= m - n && !s.substring(i).equals(t)) {
					sb.append(s.substring(i));
				}
			}
			result.add(sb.toString());

			i += n;
			j += n;
			
			if (i >= m - n && i < m && !s.substring(i).equals(t)) {
				result.add(s.substring(i));
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		SplitString test = new SplitString();
		String s = "abcdeabcdeabcdeabc";
		List<String> result = test.splitByString(s, "abc");
		System.out.println(result);
	}

}
