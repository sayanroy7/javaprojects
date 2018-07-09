/**
 * 
 */
package com.sr.tree.binary;

/**
 * @author sayanroy
 *
 */
public class BinarySearchTreeOps {

	public static BinarySearchTreeNode findRecursive(BinarySearchTreeNode root,
			int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() == data) {
			return root;
		}
		BinarySearchTreeNode node = null;
		if (root.getData() > data) {
			node = findRecursive(root.getLeft(), data);
		} else if (root.getData() < data) {
			node = findRecursive(root.getRight(), data);
		}
		return node;
	}

	public static BinarySearchTreeNode findIterative(BinarySearchTreeNode root,
			int data) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.getData() > data) {
				root = root.getLeft();
			} else if (root.getData() < data) {
				root = root.getRight();
			} else {
				return root;
			}
		}
		return null;
	}

	/**
	 * The min element is always the left most node in BST.
	 * 
	 * LOGIC: keep iterating from root towards the left node until the left is
	 * not null. For the node which left is null, that would be the min node.
	 * return that node.
	 * 
	 * <br/>
	 * <br/>
	 * <b>NOTE :</b> If root is null, return null. If root doesn't have any left
	 * subtree then root is the min element in BST, return root.
	 * 
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode findMinRecursive(
			BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.getLeft() == null) {
			return root;
		}
		return findMinRecursive(root.getLeft());
	}

	public static BinarySearchTreeNode findMinIterative(
			BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		while (root.getLeft() != null) {
			root = root.getLeft();
		}
		return root;
	}

	public static BinarySearchTreeNode findMaxRecursive(
			BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.getRight() == null) {
			return root;
		}
		return findMaxRecursive(root.getRight());
	}

	/**
	 * The approach is same as findMin. Only in place of the left we'll check
	 * for extreme right node.
	 * 
	 * @param root
	 * @return
	 */
	public static BinarySearchTreeNode findMaxIterative(
			BinarySearchTreeNode root) {
		if (root == null) {
			return null;
		}
		while (root.getRight() != null) {
			root = root.getRight();
		}
		return root;
	}

	public static BinarySearchTreeNode insertRecursive(
			BinarySearchTreeNode root, int data) {
		if (root == null) {
			return new BinarySearchTreeNode(data);
		}
		if (data < root.getData()) {
			root.setLeft(insertRecursive(root.getLeft(), data));
		} else if (data > root.getData()) {
			root.setRight(insertRecursive(root.getRight(), data));
		}
		return root;
	}

	public static BinarySearchTreeNode insertIterative(
			BinarySearchTreeNode root, int data) {
		BinarySearchTreeNode node = new BinarySearchTreeNode(data);
		if (root == null) {
			return node;
		}
		BinarySearchTreeNode parent = null, current = root;
		while (current != null) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			}
		}

		if (data < parent.getData()) {
			parent.setLeft(node);
		} else if (data > parent.getData()) {
			parent.setRight(node);
		}
		return root;
	}

	public static BinarySearchTreeNode delete(BinarySearchTreeNode root,
			int data) {
		BinarySearchTreeNode temp = null;
		if (root == null) {
			return root;
		}
		if (data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		} else if (data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if (root.getLeft() == null && root.getRight() == null) {
				// leaf node
				root = null;
			} else if (root.getLeft() == null) {
				// One child - the right child is present
				temp = root;
				root = root.getRight();
				temp = null;
			} else if (root.getRight() == null) {
				// One child - the left child is present
				temp = root;
				root = root.getLeft();
				temp = null;
			} else {
				// two children/subtree present for the node to be deleted
				temp = findMinIterative(root.getRight());
				root.setData(temp.getData());
				root.setRight(delete(root.getRight(), temp.getData()));
			}
		}
		return root;
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

		System.out.println("Find recursive: " + findRecursive(root, 5));
		System.out.println("Find iterative: " + findIterative(root, 19));
		System.out.println("Find min Recursive: " + findMinRecursive(root));
		System.out.println("Find min Interative: " + findMinIterative(root));
		System.out.println("Find max Recursive: " + findMaxRecursive(root));
		System.out.println("Find max Iterative: " + findMaxIterative(root));

		System.out.println("Node inserted: "
				+ findMinIterative(insertIterative(root, -17)));
		System.out.println("LOT: ");
		BinarySearchTreeTraversal.levelOrderTraversalRecursive(root);
		System.out.println("\nInorder: ");
		BinarySearchTreeTraversal.inOrderIterative(root);
		System.out.println("Node delete: "+ delete(root, 7));
		// System.out.println("Node ");
		
		
		System.out.println("LOT: ");
		BinarySearchTreeTraversal.levelOrderTraversalRecursive(root);
		System.out.println("\nInorder: ");
		BinarySearchTreeTraversal.inOrderIterative(root);

	}

}
