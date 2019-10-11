import java.util.Stack;

class Calculater{
    public static void main(String[] args) {
        Calculater cal = new Calculater();
        String s = "1+3*5-2";
        String s1 = "(1+(4+5+2)-3)+(6+8)";
        String s2 = "2*(3+5)-9";
        System.out.println(cal.calculateI(s));
        System.out.println(cal.calculateII(s1));
        System.out.println(cal.calculateIII(s2));
    }
    public int calculateI(String s){
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0, sum = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                sum = sum*10 + s.charAt(i)-'0';
            }
            if(!Character.isDigit(s.charAt(i)) || i == len -1){
                if(sign=='+'){
                    stack.push(sum);
                }
                else if(sign=='-'){
                    stack.push(-sum);
                }
                else if(sign=='*'){
                    stack.push(stack.pop()*sum);
                }
                else if(sign=='/'){
                    stack.push(stack.pop()/sum);
                }
                sign = s.charAt(i);
                sum = 0;
            }
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
    public int calculateII(String s){
        int len = s.length(), ans = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while(Character.isDigit(s.charAt(i+1)) && i<len-1){
                    sum = sum*10 + s.charAt(i+1) - '0';
                    i++;
                }
                ans += sum*sign;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                ans = ans*stack.pop() + stack.pop();
            }
        }
        return ans;
    }
    public int calculateIII(String s){
        int len = s.length();
        Stack<Integer> number = new Stack<>();
        Stack<Character> op = new Stack<>();
        int sum = 0;
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                sum = s.charAt(i)-'0';
                while(i<len-1 && Character.isDigit(s.charAt(i+1))){
                    sum += sum*10 + s.charAt(i+1) -'0';
                    i++;
                }
                number.add(sum);
                sum = 0;
            }
            else if(s.charAt(i)=='('){
                op.add(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while(op.peek()!='('){
                    number.add(operation(op.pop(), number.pop(), number.pop()));
                }
                op.pop();
            }
            else if(s.charAt(i) =='+'||s.charAt(i) =='-'||s.charAt(i) =='*'||s.charAt(i) =='/'){
                while(!op.isEmpty()&&precedence(s.charAt(i),op.peek())){
                    number.add(operation(op.pop(), number.pop(), number.pop()));
                }
                op.add(s.charAt(i));
            } 
        }
        while(!op.isEmpty()){
            number.add(operation(op.pop(), number.pop(), number.pop()));
        }
        return number.pop();
    }
    private int operation(char op, int  b, int a){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }
    private boolean precedence(char op1, char op2){
        if(op2=='('||op2==')') return false;
        if((op1 =='*' || op1 =='/')&&(op2 =='+' || op2 =='-')) return false;
        return true;
    }
}