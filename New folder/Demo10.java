import java.util.Scanner;
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
      Stack<Character>stack=new Stack<>();
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='(' || c=='{' || c=='['){
            stack.push(c);
        }else{
            if(stack.empty()) return false;
            char top=stack.pop();
            if((c==')' && top!='(')||
               (c=='}' && top!='{')||
               (c==']' && top!='[')){
                return false;
               }
        }
      } 
      return stack.isEmpty();
    }
}
public class Demo10{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:" );
        String s=sc.next();
        Solution solution=new Solution();
        System.out.println(solution.isValid(s));

    }
}