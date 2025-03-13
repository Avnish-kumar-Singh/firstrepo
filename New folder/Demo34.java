import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    int abc(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.data;
        }
        int L_sum = abc(root.left);
        int R_sum = abc(root.right);

        if (L_sum == -1 || R_sum == -1) {
            return -1;
        }

        if (root.data != L_sum + R_sum) {
            return -1;
        }
        return root.data + L_sum + R_sum;
    }

    Boolean isSumTree(Node root) {
        return abc(root) != -1;
    }

    
    public Node insertLevelOrder(int[] arr, Node root, int i) {
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}

public class Demo34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the tree:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Tree is empty.");
            return;
        }

        System.out.println("Enter the elements of the tree:");
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        Node root = sol.insertLevelOrder(nodes, null, 0);

        System.out.println("The tree is a sum tree: " + sol.isSumTree(root));

        sc.close();
    }
}
