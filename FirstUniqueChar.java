package goldman;

public class FirstUniqueChar {
    public String firstUnique(String s){
        int[] alp = new int[256];
        char[] arr =s.toCharArray();

        for(char c : arr ){
            alp[c]++;
        }
        int i;
        for(i = 0; i < arr.length; i++) {
            if (alp[arr[i]] == 1)
                break;
        }
        return "" + arr[i];
    }

    public static void main(String[] args){
        String s = "l";
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUnique(s));
    }
}
