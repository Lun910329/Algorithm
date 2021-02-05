import java.util.*;
class AddressGenerator{
public static void main(String[] args) {
    String s = "1130 S Michigan Ave";
    List<String> ans = getAddress(s);
    for(String s1 : ans){
        System.out.println(s1);
    }
}
static  List<String>  getAddress(String s){
    Set<String> set = new HashSet<>();
    // String[] count = s.split(" ");
    boolean direction = false;
    boolean ave = false;
    for(int i=0;i<s.length();i++){
        StringBuilder sb = new StringBuilder();
        String[] count = s.split(" ");
        for(String temp:count){
            if(temp.equals("S")){
                if(direction){
                    sb.append(temp);
                    sb.append(" ");
                    continue;
                }
                sb.append("South");
                direction = true;
                sb.append(" ");
            }
            else if(temp.equals("Ave")){
                if(ave){
                    sb.append(temp);
                    sb.append(" ");
                    continue;
                }
                sb.append("Avenue");
                ave = true;
                sb.append(" ");
            }
            else{
                sb.append(temp);
                sb.append(" ");
            }
        }
        set.add(sb.toString());
    }
    List<String> ans = new ArrayList<>(set);
    return ans;
}
}