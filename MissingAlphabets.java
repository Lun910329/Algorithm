package goldman;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class MissingAlphabets {
    public List<Character> find(String word) {
        int[] index = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            index[ch - 'a']++;
        }

        List<Character> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (index[c - 'a'] == 0) {
                result.add(c);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        String word = "abcdefg";
        List<Character> list = new MissingAlphabets().find(word);
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.print(sb.toString());
    }
}
