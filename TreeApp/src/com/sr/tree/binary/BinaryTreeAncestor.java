/**
 * 
 */
package com.sr.tree.binary;

/**
 * @author sayanroy
 *
 */
public class BinaryTreeAncestor {

	public static boolean printAllAncestor(BinaryTreeNode root,
			BinaryTreeNode node) {
		if (root != null) {
			if (root.equals(node)) {
				return true;
			}
			if (printAllAncestor(root.getLeft(), node)
					|| printAllAncestor(root.getRight(), node)) {
				System.out.print(root.getData() + " ");
				return true;
			}
		}
		return false;
	}

	public static BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode n1,
			BinaryTreeNode n2) {
		if (root == null) {
			return root;
		}
		if (root.equals(n1) || root.equals(n2)) {
			return root;
		}
		BinaryTreeNode left = LCA(root.getLeft(), n1, n2);
		BinaryTreeNode right = LCA(root.getRight(), n1, n2);
		if (left != null && right != null) {
			return root;
		} else {
			return left != null ? left : right;
		}

	}

}
