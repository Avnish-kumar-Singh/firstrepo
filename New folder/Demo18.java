import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

class Solution {
    public int getMaxArea(Vector<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = arr.size();

        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr.get(st.peek()) > arr.get(i)) {
                int element = st.pop();
                int x = i;
                int y = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(arr.get(element) * (x - y - 1), maxArea);
            }
            st.push(i);
        }

       
        while (!st.isEmpty()) {
            int element = st.pop();
            int x = n;
            int y = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (x - y - 1) * arr.get(element));
        }

        return maxArea;
    }
}

public class Demo18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        Vector<Integer> arr = new Vector<>();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        sc.close(); 

        Solution sol = new Solution();
        System.out.println("The maximum area of the histogram is: " + sol.getMaxArea(arr));
    }
}
