/**
 * 
 */
package com.sr.tree.binary;

/**
 * @author sayanroy
 *
 */
public class BuildBinaryTree {

	public static BinaryTreeNode buildBinaryTree(int[] inorder, int[] preorder) {
		if (preorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		return buildBT(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

	}

	private static BinaryTreeNode buildBT(int[] preorder, int preStart,
			int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		int data = preorder[preStart];
		BinaryTreeNode tree = new BinaryTreeNode(data);
		int offset = inStart;
		for (; offset < inEnd; offset++) {
			if (inorder[offset] == data) {
				break;
			}
		}
		tree.setLeft(buildBT(preorder, preStart + 1, offset + preStart
				- inStart, inorder, inStart, offset - 1));
		tree.setRight(buildBT(preorder, offset + preStart - inStart + 1,
				preEnd, inorder, offset + 1, inEnd));
		return tree;

	}

}
