import java.util.*;
class encod{
    public static String encode(String s){
        char[] count = s.toCharArray();
        int index = 0;
        int charIndex = 0;
        StringBuilder sb = new StringBuilder();
        while(index<s.length()){
            int charCount = 0;
            char temp = s.charAt(index);
            sb.append(temp);
            while(charIndex<s.length() && temp == s.charAt(charIndex)){
                charIndex++;
                charCount++;
            }
            if(charCount!=1){
            sb.append(String.valueOf(charCount));
            }
            index = charIndex;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(encode(s));
    }
}