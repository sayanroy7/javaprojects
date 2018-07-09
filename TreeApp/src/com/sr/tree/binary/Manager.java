/**
 * 
 */
package com.sr.tree.binary;

/**
 * [4] [5] [6] [7] [8] [9] [10]
 * 
 * @author sayanroy
 */
public class Manager {

	/**
	 * @param args
	 */
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

		/*
		 * BinaryTreeTraversal.preOrderRecursive(root);
		 * BinaryTreeTraversal.preOrderIterative(root); System.out.println("");
		 * BinaryTreeTraversal.inOrderRecursive(root); System.out.println("");
		 * BinaryTreeTraversal.inOrderIterative(root); System.out.println("");
		 * BinaryTreeTraversal.postOrderRecursive(root); System.out.println("");
		 * BinaryTreeTraversal.postOrderIterativeTwoStack(root);
		 * System.out.println("");
		 * BinaryTreeTraversal.postOrderIterativeOneStack(root);
		 */

		BinaryTreeNode root1 = new BinaryTreeNode(5);

		BinaryTreeNode left1 = new BinaryTreeNode(-4);
		left1.setRight(new BinaryTreeNode(13));

		BinaryTreeNode right1 = new BinaryTreeNode(8);
		right1.setRight(new BinaryTreeNode(27));
		BinaryTreeNode right1left = new BinaryTreeNode(52);
		right1left.setLeft(new BinaryTreeNode(-19));
		right1.setLeft(right1left);

		root1.setLeft(left1);
		root1.setRight(right1);

		/*
		 * System.out.println(" New node");
		 * System.out.println("Postorder recursive: ");
		 * BinaryTreeTraversal.postOrderRecursive(root1);
		 * System.out.println(""); System.out.println("Postorder iterative: ");
		 * BinaryTreeTraversal.postOrderIterativeOneStack(root1);
		 * 
		 * System.out.println("\n preorder: ");
		 * BinaryTreeTraversal.preOrderIterative(root1);
		 */

		System.out
				.println("\n ================================================================");

		System.out.println("Height root1: "
				+ BinaryTreeUtils.heightWithoutRecursion(root1));
		System.out.println("Height root1 recursion: "
				+ BinaryTreeUtils.height(root1));

		System.out.println("Min depth: " + BinaryTreeProbs.findMinDepth(root1));
		System.out.println("Width: " + BinaryTreeProbs.width(root));

		/*
		 * BinaryTreeTraversal.levelOrderTraversalRecursive(root);
		 * 
		 * System.out.println("");
		 * BinaryTreeTraversal.levelOrderTraversalIterative(root1);
		 * 
		 * System.out.println("\nThe max value: "+
		 * BinaryTreeUtils.findMaxElement(root1));
		 * System.out.println(" Element found? "+
		 * BinaryTreeUtils.findIterative(root1, 53));
		 * 
		 * //BinaryTreeUtils.insertAtNodeRecursive(root1, 53);
		 * BinaryTreeUtils.insertAtNodeIterative(root1, 53);
		 * 
		 * System.out.println("\nThe max value: "+
		 * BinaryTreeUtils.findMaxElement(root1));
		 * System.out.println(" Element found? "+
		 * BinaryTreeUtils.findIterative(root1, 53));
		 * 
		 * System.out.println("");
		 * BinaryTreeTraversal.levelOrderTraversalIterative(root1);
		 */

		System.out.println("\nLOT ");
		BinaryTreeTraversal.levelOrderTraversalIterative(root);
		System.out.println("\nLOT mirror ");
		BinaryTreeTraversal.levelOrderTraversalIterative(BinaryTreeProbs
				.mirror1(root));
		System.out.println("\nLOT mirror ");
		// This actually converts the passed tree to its' mirror
		BinaryTreeTraversal.levelOrderTraversalIterative(BinaryTreeProbs
				.mirror2(root));
		System.out.println("\nLOT ");
		BinaryTreeTraversal.levelOrderTraversalIterative(root);
		// System.out.println("\nLOT reverse ");
		// BinaryTreeProbs.levelOrderTraversalReverse(root);

		BinaryTreeNode tree = BuildBinaryTree.buildBinaryTree(new int[] { 7, 5,
				8, 4, 9, 6, 10 }, new int[] { 4, 5, 7, 8, 6, 9, 10 });
		System.out.println("\nLOT");
		BinaryTreeTraversal.levelOrderTraversalRecursive(tree);
		
		BinaryTreeNode tNode = new BinaryTreeNode(9);
		System.out.println("Ancestor of node: "+ tNode);
		BinaryTreeAncestor.printAllAncestor(root, tNode);
		
		System.out.println("\nLCA: "+ BinaryTreeAncestor.LCA(root, new BinaryTreeNode(5), new BinaryTreeNode(6)));
		
		
		System.out.println("Distance of 9: "+ BinaryTreeProbs.findDistance(root1, -19));

	}

}
