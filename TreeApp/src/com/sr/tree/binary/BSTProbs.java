/**
 * 
 */
package com.sr.tree.binary;

/**
 * @author sayanroy
 *
 */
public class BSTProbs {

	public static BinarySearchTreeNode LCA(BinarySearchTreeNode root,
			BinarySearchTreeNode n1, BinarySearchTreeNode n2) {
		if (root == null) {
			return root;
		}
		if (root.equals(n1) || root.equals(n2)) {
			return root;
		}

		if (root.getData() > Math.max(n1.getData(), n2.getData())) {
			// root is greater than the max of both. So we need search in the
			// left side of root.
			return LCA(root.getLeft(), n1, n2);
		} else if (root.getData() < Math.min(n1.getData(), n2.getData())) {
			// root is smaller than the min of both. So we need to search in the
			// right side of root.
			return LCA(root.getRight(), n1, n2);
		} else {
			// Root is in between n1 and n2. So root is the LCA.
			return root;
		}
	}
	
	public static BinarySearchTreeNode inOrderSuccessor(BinarySearchTreeNode node) {
		if (node == null) {
			return node;
		}
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public static void main(String[] args) {
		BinarySearchTreeNode root = new BinarySearchTreeNode(5);
		BinarySearchTreeNode left = new BinarySearchTreeNode(3);
		left.setLeft(new BinarySearchTreeNode(2));
		left.setRight(new BinarySearchTreeNode(4));
		BinarySearchTreeNode right = new BinarySearchTreeNode(7);
		right.setLeft(new BinarySearchTreeNode(6));
		right.setRight(new BinarySearchTreeNode(8));
		root.setLeft(left);
		root.setRight(right);

		System.out.println("LCA: 8 and 6 >> "
				+ LCA(root, new BinarySearchTreeNode(8),
						new BinarySearchTreeNode(6)));
	}

}
