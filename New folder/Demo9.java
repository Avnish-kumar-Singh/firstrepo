import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0); // Dummy node
        temp.next = head;

        ListNode first = temp;
        ListNode second = temp;

        // Move `first` pointer `n` steps ahead
        for (int i = 0; i < n; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                return head; // If `n` is invalid (larger than list size)
            }
        }

        // Move both pointers until `first` reaches the last node
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the `nth` node from the end
        second.next = second.next.next;

        return temp.next; // Return new head
    }
}

public class Demo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements for List:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Enter the list elements:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        // Loop runs `n-1` times since first element is already initialized
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.println("Enter the value of n (position from the end to remove):");
        int removeN = sc.nextInt();

        if (removeN > n || removeN <= 0) {
            System.out.println("Invalid value of n.");
            return;
        }

        Solution solution = new Solution();
        head = solution.removeNthFromEnd(head, removeN);

        System.out.println("Modified List:");
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
