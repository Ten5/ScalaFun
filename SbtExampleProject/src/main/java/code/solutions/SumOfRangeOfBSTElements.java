package code.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary search tree and a range [a, b] (inclusive), return the sum of the elements of the binary search tree within the range.
 *
 * For example, given the following tree:
 *
 *     5
 *    / \
 *   3   8
 *  / \ / \
 * 2  4 6  10
 * and the range [4, 9], return 23 (5 + 4 + 6 + 8).
 */

public class SumOfRangeOfBSTElements {

    public static void main(String[] args) {

        int[] elements = {5, 3, 8, 2, 4, 6, 10};
        TreeNode root = createBST(elements);
        int[] range = {4, 5};

        int total = 0;
        int lower = range[0];
        int upper = range[1];
        System.out.println(greedyRangeAdd(root, total, lower, upper));
    }

    private static TreeNode createBST(int[] elements) {
        Arrays.sort(elements);
        return createBST(elements, 0, elements.length - 1);
    }

    private static TreeNode createBST(int[] elements, int lower, int upper) {
        if(lower > upper)
            return null;

        int n = (lower + upper) / 2;
        TreeNode node = new TreeNode(elements[n]);
        node.left = createBST(elements, lower, n - 1);
        node.right = createBST(elements, n + 1, upper);

        return node;
    }

    private static void inOrderBST(TreeNode node, List<Integer> elements) {
        if(node == null)
            return;

        inOrderBST(node.left, elements);
        elements.add(node.val);
        inOrderBST(node.right, elements);
    }

    /**
     * greedyRangeAdd is a method which greedily (postorder search) adds the values
     * of the nodes if its in the provided range and returns the overall sum of
     * all the values in the BST.
     */
    private static int greedyRangeAdd(TreeNode node, int total, int lower, int upper) {
        if(node == null)
            return 0;

        int left = greedyRangeAdd(node.left, total, lower, upper);
        int right = greedyRangeAdd(node.right, total, lower, upper);
        if(node.val >= lower && node.val <= upper)
            total += node.val;

        return total + left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}