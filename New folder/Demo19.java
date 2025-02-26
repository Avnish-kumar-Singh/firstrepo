import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

class Solution {
   
    public Vector<Integer> abc(Vector<Integer> arr, int n) {
        Stack<Integer> st = new Stack<>();
        Vector<Integer> x = new Vector<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr.get(st.peek()) >= arr.get(i)) {
                st.pop();
            }
            if (!st.isEmpty()) {
                x.add(st.peek());
            } else {
                x.add(-1);
            }
            st.push(i);
        }
        return x;
    }

   
    public Vector<Integer> xyz(Vector<Integer> arr, int n) {
        Stack<Integer> st = new Stack<>();
        Vector<Integer> y = new Vector<>();
        
        for (int i = 0; i < n; i++) {
            y.add(n);  
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr.get(st.peek()) > arr.get(i)) {
                st.pop();
            }
            if (!st.isEmpty()) {
                y.set(i, st.peek());
            }
            st.push(i);
        }
        return y;
    }

    
    public Vector<Integer> maxOfMin(Vector<Integer> arr) {
        int n = arr.size();
        Vector<Integer> x = abc(arr, n);
        Vector<Integer> y = xyz(arr, n);
        Vector<Integer> ans = new Vector<>();

        for (int i = 0; i < n; i++) {
            ans.add(0);  
        }

        for (int i = 0; i < n; i++) {
            int len = y.get(i) - x.get(i) - 1;
            ans.set(len - 1, Math.max(ans.get(len - 1), arr.get(i)));
        }

        
        for (int i = n - 2; i >= 0; i--) {
            ans.set(i, Math.max(ans.get(i), ans.get(i + 1)));
        }

        return ans;
    }
}


public class Demo19 {
    public static void main(String[] args) {
        //int i;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        Vector<Integer> arr = new Vector<>();
        
        System.out.println("Enter the elements:");
        for ( int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();

        Solution sol = new Solution();
        Vector<Integer> ans = sol.maxOfMin(arr);
        System.out.println("The maximum of minimum of every window of size is:");
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
