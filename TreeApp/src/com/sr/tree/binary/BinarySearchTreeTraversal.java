/**
 * 
 */
package com.sr.tree.binary;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sayanroy
 *
 */
public class BinarySearchTreeTraversal {

	/**
	 * DLR -
	 * 
	 * 1. D is current node 2. L is left of D node 3. R is right of D node
	 * 
	 * @param root
	 */
	public static void preOrderRecursive(BinarySearchTreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + " "); // D
			preOrderRecursive(root.getLeft()); // L
			preOrderRecursive(root.getRight()); // R
		}
	}

	/**
	 * DLR -
	 * 
	 * 1. D is current node 2. L is left of D node 3. R is right of D node
	 * 
	 * @param root
	 */
	public static void preOrderIterative(BinarySearchTreeNode root) {
		// List<Integer> dataList = new ArrayList<Integer>();
		Stack<BinarySearchTreeNode> stack = new Stack<BinarySearchTreeNode>();
		if (root != null) {
			stack.push(root);
			System.out.print("\n");
			while (!stack.isEmpty()) {
				BinarySearchTreeNode temp = stack.pop();
				System.out.print(temp.getData() + " ");
				// dataList.add(temp.getData());
				if (temp.getRight() != null) {
					stack.push(temp.getRight());
				}
				if (temp.getLeft() != null) {
					stack.push(temp.getLeft());
				}
			}
		}
		// System.out.println("The traversal data is: "+ dataList);
	}

	/**
	 * Order of traversal LDR -
	 * 
	 * 1. D is current node 2. L is left of D node 3. R is right of D node
	 * 
	 * @param root
	 */
	public static void inOrderRecursive(BinarySearchTreeNode root) {
		if (root != null) {
			inOrderRecursive(root.getLeft()); // L
			System.out.print(root.getData() + " "); // D
			inOrderRecursive(root.getRight()); // R
		}
	}

	/**
	 * Order of traversal LDR -
	 * 
	 * 1. D is current node 2. L is left of D node 3. R is right of D node
	 * 
	 * @param root
	 */
	public static void inOrderIterative(BinarySearchTreeNode root) {
		boolean done = false;
		Stack<BinarySearchTreeNode> stack = new Stack<BinarySearchTreeNode>();
		BinarySearchTreeNode current = root;

		while (!done) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					current = stack.pop();
					System.out.print(current.getData() + " ");
					current = current.getRight();
				}
			}
		}
	}

	/**
	 * LRD - 1. D is current node 2. L is left of D node 3. R is right of D node
	 * 
	 * @param root
	 */
	public static void postOrderRecursive(BinarySearchTreeNode root) {
		if (root != null) {
			postOrderRecursive(root.getLeft()); // L
			postOrderRecursive(root.getRight()); // R
			System.out.print(root.getData() + " "); // D
		}
	}

	public static void postOrderIterativeTwoStack(BinarySearchTreeNode root) {
		Stack<BinarySearchTreeNode> s1 = new Stack<BinarySearchTreeNode>();
		Stack<BinarySearchTreeNode> s2 = new Stack<BinarySearchTreeNode>();

		if (root != null) {
			s1.push(root);
			while (!s1.isEmpty()) {
				BinarySearchTreeNode temp = s1.pop();
				if (temp.getLeft() != null) {
					s1.push(temp.getLeft());
				}
				if (temp.getRight() != null) {
					s1.push(temp.getRight());
				}
				s2.push(temp);
			}

			while (!s2.isEmpty()) {
				System.out.print(s2.pop().getData() + " ");
			}
		}

	}

	public static void postOrderIterativeOneStack(BinarySearchTreeNode root) {
		Stack<BinarySearchTreeNode> stack = new Stack<BinarySearchTreeNode>();
		BinarySearchTreeNode current = root;
		BinarySearchTreeNode prev = null;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				current = stack.peek();
				if (prev != null && prev.equals(current.getRight())) {
					prev = stack.pop();
					System.out.print(prev.getData() + " ");// Ready to be
															// processed
					current = null; // setting current to null
				} else if (current.getRight() != null) {
					current = current.getRight();
				} else {
					prev = stack.pop();
					System.out.print(prev.getData() + " "); // Ready to be
															// processed
					current = null; // setting current to null
				}

			}
		}
	}

	public static void levelOrderTraversalRecursive(BinarySearchTreeNode root) {
		int height = height(root);
		System.out.println("Height is: " + height);

		for (int i = 1; i <= height; i++) {
			levelOrderTraversal(root, i);
		}
	}

	public static int height(BinarySearchTreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}

	/**
	 * This method will recursively print the data in level order traversal for
	 * each level passed to it.
	 * 
	 * @param node
	 * @param level
	 */
	private static void levelOrderTraversal(BinarySearchTreeNode node, int level) {
		if (level == 1) {
			System.out.print(node.getData() + " ");
		} else {
			if (node.getLeft() != null) {
				levelOrderTraversal(node.getLeft(), level - 1);
			}
			if (node.getRight() != null) {
				levelOrderTraversal(node.getRight(), level - 1);
			}
		}
	}

	/**
	 * The iterative version uses a queue to store the element of each level.
	 * 
	 * @param root
	 */
	public static void levelOrderTraversalIterative(BinarySearchTreeNode root) {
		if (root != null) {
			Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				BinarySearchTreeNode node = q.poll();
				System.out.print(node.getData() + " ");
				if (node.getLeft() != null) {
					q.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					q.offer(node.getRight());
				}
			}
		}
	}
}
