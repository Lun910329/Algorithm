package goldman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubString {
    public String[] sub(String s, int k){
        if(k > s.length())
            return new String[0];
        
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < s.length() - k + 1; i++){
            set.add(s.substring(i, i + k));
        }
        
        String[] result = set.toArray(new String[set.size()]);
        return result;
    }

    public static void main(String[] args){
        SubString subString = new SubString();
        String s = "caaabdeaabf";
        System.out.println(Arrays.toString(subString.sub(s,3)));
    }
}
