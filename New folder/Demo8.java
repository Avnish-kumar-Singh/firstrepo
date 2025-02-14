import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution {
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || getLength(digits) == 0) return result; 
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        if (index == getLength(digits)) { 
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        int digitIndex = digit - '0';
        String letters = KEYPAD[digitIndex]; 

        for (int i = 0; i < getLength(letters); i++) { 
            current.append(letters.charAt(i));
            backtrack(result, digits, current, index + 1);
            current.deleteCharAt(getLength(current.toString()) - 1);
        }
    }

    
    private int getLength(String str) {
        int count = 0;
        for (int i = 0; ; i++) { 
            try {
                str.charAt(i); 
                count++;       
            } catch (IndexOutOfBoundsException e) {
                break; 
            }
        }
        return count;
    }
}

public class Demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits (2-9): ");
        String digits = sc.nextLine();
        sc.close();

        Solution solution = new Solution();
        List<String> combinations = solution.letterCombinations(digits);

        System.out.println("Letter Combinations: " + combinations);
    }
}
