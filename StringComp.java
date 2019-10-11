package goldman;

public class StringComp {
    public String compression(String str) {
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
            	sb.append(count).append(last);
                count = 1;  // here count should be 1 but not 0
            }
            last = str.charAt(i);
        }
          sb.append(count).append(last);

        String newStr = sb.toString();
        return newStr;
    }

        public static void main(String[] args){
            StringComp stringComp = new StringComp();
            String str = "ab";
            System.out.println(stringComp.compression(str));
        }
}
