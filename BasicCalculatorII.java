public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        char operator='+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                ans = ans*10 + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch != ' ') || i==s.length()-1){
                if(operator =='+'){
                    stack.push(ans);
                }else if(operator =='-'){
                    stack.push(-1*ans);
                }else if(operator=='*'){
                    stack.push(ans*stack.pop());
                }else if(operator == '/'){
                    stack.push(stack.pop()/ans);
                }
                ans =0;
                operator =ch;

            }

        }
        int sum=0;
        while(!stack.isEmpty()){
            sum = sum+stack.pop();
        }
        return sum;
    }
}