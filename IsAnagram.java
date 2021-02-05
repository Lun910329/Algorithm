

import java.util.Arrays;

public class IsAnagram {
    public boolean ana(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args){
        IsAnagram isAnagram = new IsAnagram();
        String s = "abcde", t = "gcade";
        System.out.println(isAnagram.ana(s, t));
    }
}
