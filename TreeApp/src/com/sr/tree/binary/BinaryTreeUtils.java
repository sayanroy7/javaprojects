/**
 * 
 */
package com.sr.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sayanroy
 *
 */
public class BinaryTreeUtils {

	public static int height(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return leftHeight > rightHeight ? leftHeight + 1
				: rightHeight + 1;
	}
	
	public static int heightWithoutRecursion(BinaryTreeNode root) {
		int count = 1; //as the root node is not counted inside the loop
		if (root != null) {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.offer(root); 
			q.offer(null); //Mark the end of level 1 as there root node is the only node.
			while (!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				if (temp != null) {
					if (temp.getLeft() != null) {
						q.offer(temp.getLeft());
					}
					if (temp.getRight() != null) {
						q.offer(temp.getRight());
					}
				} else {
					if (!q.isEmpty()) {
						count++;
						q.offer(null); //Mark the end of level which has been iterated till the last null
					}
				}
			}
		}
		return count;
	}

	public static int findMaxElement(BinaryTreeNode root) {
		if (root == null) {
			throw new RuntimeException("No elements in the tree!");
		} else {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			int max = Integer.MIN_VALUE;
			q.offer(root);
			while (!q.isEmpty()) {
				BinaryTreeNode node = q.poll();
				if (node.getData() >= max) {
					max = node.getData();
				}
				if (node.getLeft() != null) {
					q.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					q.offer(node.getRight());
				}
			}
			return max;
		}
	}

	public static boolean findRecursive(BinaryTreeNode root, int data) {
		if (root == null) {
			return false;
		} else if (data == root.getData()) {
			return true;
		} else {
			return findRecursive(root.getLeft(), data)
					|| findRecursive(root.getRight(), data);
		}
	}
	
	public static boolean findIterative(BinaryTreeNode root, int data) {
		boolean found = false;
		if (root != null) {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				BinaryTreeNode node = q.poll();
				if (data == node.getData()) {
					found = true;
					break;
				}
				if (node.getLeft() != null) {
					q.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					q.offer(node.getRight());
				}
			}
		}
		return found;
	}
	
	public static void insertAtNodeRecursive(BinaryTreeNode root, int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		} else {
			insertHelper(root, data);
		}
	}
	
	private static boolean insertHelper(BinaryTreeNode root, int data) {
		if (root.getLeft() == null) {
			root.setLeft(new BinaryTreeNode(data));
			return true;
		} else if (root.getRight() == null) {
			root.setRight(new BinaryTreeNode(data));
			return true;
		} else {
			return insertHelper(root.getLeft(), data) ||
					insertHelper(root.getRight(), data);
		}
	}
	
	public static void insertAtNodeIterative(BinaryTreeNode root, int data) {
		BinaryTreeNode node = new BinaryTreeNode(data);
		if (root == null) {
			root = node;
		} else {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				if (temp == null) {
					temp = node;
					break;
				}
				
				if (temp.getLeft() == null) {
					temp.setLeft(node);
					break;
				} else if (temp.getRight() == null) {
					temp.setRight(node);
					break;
				} else {
					q.offer(temp.getLeft());
					q.offer(temp.getRight());
				}
			}
			q.clear();
			q = null;
		}
	}
}
