import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode x = new ListNode(-1);
        ListNode y = x;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                y.next = list1;
                list1 = list1.next;
            } else {
                y.next = list2;
                list2 = list2.next;
            }
            y = y.next;
        }
        
        if (list1 != null) y.next = list1;
        if (list2 != null) y.next = list2;
        
        return x.next;
    }
}

public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for first list
        System.out.print("Enter number of elements in first list: ");
        int n = sc.nextInt();
        ListNode head1 = null, temp1 = null;
        
        if (n > 0) {
            System.out.print("Enter elements of first list: ");
            head1 = new ListNode(sc.nextInt());
            temp1 = head1;
            for (int i = 1; i < n; i++) {
                temp1.next = new ListNode(sc.nextInt());
                temp1 = temp1.next;
            }
        }

        // Take input for second list
        System.out.print("Enter number of elements in second list: ");
        int m = sc.nextInt();
        ListNode head2 = null, temp2 = null;
        
        if (m > 0) {
            System.out.print("Enter elements of second list: ");
            head2 = new ListNode(sc.nextInt());
            temp2 = head2;
            for (int i = 1; i < m; i++) {
                temp2.next = new ListNode(sc.nextInt());
                temp2 = temp2.next;
            }
        }

        // Merge two sorted lists
        Solution obj = new Solution();
        ListNode result = obj.mergeTwoLists(head1, head2);

        // Print the merged list
        System.out.print("Merged Sorted List: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
        
        // Close scanner
        sc.close();
    }
}
