import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    private Stack<Integer> st;
    private Stack<Integer> minStack;

    public Solution() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            int removed = st.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int peek() {
        return st.isEmpty() ? -1 : st.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}

public class Demo20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking number of queries
        System.out.println("Enter the number of queries:");
        int q = sc.nextInt();
        sc.nextLine(); // Consume newline

        Solution sol = new Solution();
        ArrayList<Integer> minValues = new ArrayList<>();

        System.out.println("Enter the queries:");
        for (int i = 0; i < q; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            int type = Integer.parseInt(parts[0]);
            if (type == 1) {  // Push operation
                int x = Integer.parseInt(parts[1]);
                sol.push(x);
            } else if (type == 2) { // Pop operation
                sol.pop();
            } else if (type == 3) { // Peek operation (missing in your logic)
                int top = sol.peek();
                if (top != -1) {
                    minValues.add(top);  // Add peek value to output tracking
                }
            } else if (type == 4) { // Get Min operation
                minValues.add(sol.getMin());
            }
        }

        sc.close();

        // Printing final output in the expected format
        System.out.print("Min from stack is ");
        for (int i = 0; i < minValues.size(); i++) {
            System.out.print(minValues.get(i));
            if (i < minValues.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
