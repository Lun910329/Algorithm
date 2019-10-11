import java.util.Stack;

class BackSpace{
    public static void main(String[] args) {
        String s1 = "bxj##tw";
        String s2 = "bxj###tw";
        // "bxj###tw"
        BackSpace bs = new BackSpace();
        System.out.println(bs.backspaceCompare(s1, s2));
    }
    public boolean backspaceCompare(String s, String t){
        return buildString(s).equals(buildString(t));
    }
    public String buildString(String s){
        Stack<Character> s1 = new Stack<>();
        for(char c : s.toCharArray()){
            if(c!='#'){
                s1.add(c);
            }
            else if(!s1.isEmpty()){
                s1.pop();
            }
        }
        return String.valueOf(s1);
    }
}