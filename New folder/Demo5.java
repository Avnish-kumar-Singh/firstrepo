import java.util.Scanner;

class Solution {
        public String LCP(String[] strs) {
            
            if(strs==null || strs.length==0){
                return "";
            }
    
            String values=strs[0];
            for(int i=1;i<strs.length;i++){
                while(strs[i].indexOf(values)!=0){
                    values=values.substring(0, values.length()-1);
                    if(values.isEmpty()){
                        return "No prefix Exists";
                    }
                }
            }
            return values;
        }
    }
   public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        int n = sc.nextInt();
        String[] strs = new String[n];
        System.out.println("Enter the strings: ");
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        Solution s = new Solution();
        System.out.println("*******************************:");
        System.out.println("So the longest common prefix is:"+s.LCP(strs));
        sc.close();
    }


}
