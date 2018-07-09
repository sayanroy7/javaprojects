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
public class BinaryTreeProbs {

	public static void levelOrderTraversalReverse(BinaryTreeNode root) {
		if (root != null) {
			Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
			Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				BinaryTreeNode temp = q.poll();
				stack.push(temp);
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}
			}

			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
		}
	}
	
	public static int findMinDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int minDepth = 1;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp == null) {
				//end of level (Level Order Traversal)
				q.offer(null);
				minDepth++;
			} else {
				if (temp.getLeft() == null && temp.getRight() == null) {
					break;
				}
				if (temp.getLeft() != null) {
					q.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					q.offer(temp.getRight());
				}
			}
		}
		return minDepth;
	}
	
	public static int width(BinaryTreeNode root) {
		int maxWidth = 0;
		int height = BinaryTreeUtils.height(root);
		for (int i = 0; i < height; i++) {
			int width = width(root, i);
			maxWidth = maxWidth > width ? maxWidth : width;
		}
		return maxWidth;
	}

	private static int width(BinaryTreeNode root, int level) {
		if (root == null) {
			return 0;
		} else {
			if (level == 0) {
				return 1;
			} else {
				return width(root.getLeft(), level - 1)
						+ width(root.getRight(), level - 1);
			}
		}
	}
	
	public static BinaryTreeNode mirror1(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode mirror = new BinaryTreeNode(root.getData());
		mirror.setLeft(mirror1(root.getRight()));
		mirror.setRight(mirror1(root.getLeft()));
		return mirror;
	}
	
	public static BinaryTreeNode mirror2(BinaryTreeNode root) {
		BinaryTreeNode temp = null;
		if (root != null) {
			mirror2(root.getLeft());
			mirror2(root.getRight());
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}
	
	/**
	 * distance is the no. of edges from root node to
	 * the node we're calculating distance for.
	 * 
	 * <br/>LOGIC: recursively calling the method with the left
	 * and right subtree from the root. If the root node is
	 * NULL we return -1.
	 * 
	 * <br/>In the boundary condition we write if the return value
	 * from the recursive function is greater than 0. If TRUE
	 * we increment the 'dist' counter which is initialized to -1.
	 * 
	 * <br/>Finally, at the end of function call stack we return the
	 * dist counter.
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static int findDistance(BinaryTreeNode root, int data) {
		if (root == null) {
			return -1;
		}
		int dist = -1;
		if (root.getData() == data || 
				(dist = findDistance(root.getLeft(), data)) >= 0
				|| (dist = findDistance(root.getRight(), data)) >= 0) {
			dist++;
		}
		return dist;
	}
	
	public static void printMaxSumAndLevel(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Not found!");
			return;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int maxSum = root.getData();
		int level = 0;
		int currSum = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			if (node == null) {
				//end of level
				maxSum = Math.max(currSum, maxSum);
				level++;
				currSum = 0;
				if (!q.isEmpty())
					q.offer(null);//adding the end of current level
			} else {
				currSum += node.getData();
				if (node.getLeft() != null) {
					q.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					q.offer(node.getRight());
				}
			}
		}
		
		System.out.println("Max Sum - "+ maxSum + " is found at level - "+ level);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(4);
		BinaryTreeNode left = new BinaryTreeNode(5);
		left.setLeft(new BinaryTreeNode(7));
		left.setRight(new BinaryTreeNode(8));
		BinaryTreeNode right = new BinaryTreeNode(6);
		right.setLeft(new BinaryTreeNode(9));
		right.setRight(new BinaryTreeNode(10));
		root.setLeft(left);
		root.setRight(right);
		
		printMaxSumAndLevel(root);
	}

}
