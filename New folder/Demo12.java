import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        abc("", 0, 0, n, ans);
        return ans;
    }

    private void abc(String curr, int o, int c, int n, List<String> ans) {
        if (o == n && c == n) {
            ans.add(curr);
            return;
        }
        if (o < n) {
            abc(curr + "(", o + 1, c, n, ans);
        }
        if (o > c) {
            abc(curr + ")", o, c + 1, n, ans);
        }
    }
}

public class Demo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        System.out.println("Generated Parentheses:");

        Solution obj = new Solution();
        // Generate the parentheses
        List<String> result = obj.generateParenthesis(n);
        
        // Print the result
        for (String s : result) {
            System.out.println(s);
        }
    }
}
