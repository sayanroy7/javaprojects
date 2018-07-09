/**
 * 
 */
package com.sr.tree.binary.bst.avl;

import com.sr.tree.binary.BSTProbs;
import com.sr.tree.binary.BinarySearchTreeTraversal;

/**
 * @author sayanroy
 *
 */
public class AVLTreeOps {

	public static int height(AVLTreeNode node) {
		if (node == null) {
			return -1;
		}
		return node.getHeight();
	}

	public static AVLTreeNode leftRotate(AVLTreeNode node) {
		if (node != null) {
			AVLTreeNode right = (AVLTreeNode) node.getRight();
			AVLTreeNode rightLeft = (AVLTreeNode) right.getLeft();

			// performing the rotation
			right.setLeft(node);
			node.setRight(rightLeft);

			// update height
			node.setHeight(Math.max(height((AVLTreeNode) node.getLeft()),
					height((AVLTreeNode) node.getRight())) + 1);
			right.setHeight(Math.max(height((AVLTreeNode) right.getLeft()),
					height((AVLTreeNode) right.getRight())) + 1);
			return right;
		}
		return node;
	}

	public static AVLTreeNode rightRotate(AVLTreeNode node) {
		if (node != null) {
			AVLTreeNode left = (AVLTreeNode) node.getLeft();
			AVLTreeNode leftRight = (AVLTreeNode) left.getRight();

			// performing the rotation
			left.setRight(node);
			node.setLeft(leftRight);

			// update height
			node.setHeight(Math.max(height((AVLTreeNode) node.getLeft()),
					height((AVLTreeNode) node.getRight())) + 1);
			left.setHeight(Math.max(height((AVLTreeNode) left.getLeft()),
					height((AVLTreeNode) left.getRight())) + 1);
			return left;
		}
		return node;
	}

	/**
	 * Time complexity: O(logn)
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static AVLTreeNode insert(AVLTreeNode root, int data) {
		if (root == null) {
			return new AVLTreeNode(data);
		}
		if (data < root.getData()) {
			// left subtree call recursively for insertion //BST Insertion
			root.setLeft(insert((AVLTreeNode) root.getLeft(), data));
		} else if (data > root.getData()) {
			// right subtree call recursively for insertion //BST Insertion
			root.setRight(insert((AVLTreeNode) root.getRight(), data));
		} else {
			return root; // No duplicates
		}

		// Insertion LOGIC ends above

		// Now lets check the height and balance according to violation
		int height = Math.max(height((AVLTreeNode) root.getLeft()),
				height((AVLTreeNode) root.getRight())) + 1;
		root.setHeight(height);

		/*
		 * Get the balance factor of this ancestor node to check whether this
		 * node became unbalanced
		 */
		int balance = getBalance(root);

		// Following checks for unbalance case and decides which rotation to
		// perform
		if (balance < -1 && data > root.getRight().getData()) {
			// addition at the right of right child. So, Left rotation is
			// required
			root = leftRotate(root);
		} else if (balance > 1 && data < root.getLeft().getData()) {
			// addition at the left of left child. So, Right rotation is
			// required
			root = rightRotate(root);
		} else if (balance < -1 && data < root.getRight().getData()) {
			// addition at the left of right child. So, Right -> Left (RL)
			// rotation is required
			// Right rotate - B
			AVLTreeNode rightChildAfterRotation = rightRotate((AVLTreeNode) root
					.getRight());
			root.setRight(rightChildAfterRotation);
			// Now left rotate - A
			root = leftRotate(root);
		} else if (balance > 1 && data > root.getLeft().getData()) {
			// addition at the right of left child. So, Left -> Right (LR)
			// rotation is required
			// Left rotate - B
			AVLTreeNode leftChildAfterRotation = leftRotate((AVLTreeNode) root
					.getLeft());
			root.setLeft(leftChildAfterRotation);
			// Now Right rotate - A
			root = rightRotate(root);
		}
		return root;
	}

	/**
	 * Time complexity: O(logn)
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	public static AVLTreeNode delete(AVLTreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (key < root.getData()) {
			// the node is in left subtree
			root.setLeft(delete((AVLTreeNode) root.getLeft(), key));
		} else if (key > root.getData()) {
			// the node is in right subtree
			root.setRight(delete((AVLTreeNode) root.getRight(), key));
		} else {
			// this is the node to be deleted
			/**
			 * Now we have found the node we'll delete it. But, following point
			 * to be considered.
			 * 
			 * Node with only one child or no child has to be treated following
			 * way.
			 */
			if (root.getLeft() == null || root.getRight() == null) {
				AVLTreeNode temp = null;
				if (root.getLeft() == temp) {
					temp = (AVLTreeNode) root.getRight();
				} else {
					temp = (AVLTreeNode) root.getRight();
				}

				if (temp == null) {
					temp = root;
                    root = null;
				} else {
					root = temp; // copy the content of the one child.
				}
			} else {
				// This conditional block will delete for nodes which has both
				// the children
				// getting inorder successor and replacing current node value
				// with it. *** BST Delete algo - 
				AVLTreeNode successor = (AVLTreeNode) BSTProbs
						.inOrderSuccessor(root.getRight());
				root.setData(successor.getData());

				// deleting inorder successor
				root.setRight(delete((AVLTreeNode) root.getRight(),
						successor.getData()));
			}
		}
		
		// If the tree had only one node then return
        if (root == null)
            return root;
		
		//updating the height of the current node i.e - 'root'
		root.setHeight(Math.max(height((AVLTreeNode) root.getLeft()), height((AVLTreeNode) root.getRight())) + 1);
		//finding the balance factor of the affected node 		
		int balanceFactor = getBalance(root);
		//based on the balance factor we have the following 4 cases.
		if (balanceFactor < -1 && getBalance((AVLTreeNode) root.getRight()) <= 0) {
			//This is case of Right -> Right imbalance. So we need to perform left rotation
			//on the 'root' (affected) node.
			root = leftRotate(root);
		} else if (balanceFactor < -1 && getBalance((AVLTreeNode) root.getRight()) > 0) {
			//This is the case of Right -> Left imbalance (RL). So, we need to perform Right rotation
			//on the right child of 'root'
			root.setRight(rightRotate((AVLTreeNode) root.getRight()));
			//Now the violation is Right->Right case. So, we perform Left rotation on 'root'
			root = leftRotate(root);
		} else if (balanceFactor > 1 && getBalance((AVLTreeNode) root.getLeft()) >= 0) {
			//This is the Left -> Left violation case. As the balanceFactor is +ve so the violation would be
			//at 'root' left and the balance factor of root->left is either +ve or 0.
			
			//To solve this we perform right rotation on the 'root' node
			root = rightRotate(root);
		} else if (balanceFactor > 1 && getBalance((AVLTreeNode) root.getLeft()) < 0) {
			//This is the case of Left -> Right violation. As the balanceFactor is +ve so the violation would
			//be at 'root' left. And the balance factor of root->left is -ve so the violation is in root->left->right
			
			//To solve this we first perform left rotation on root->left
			root.setLeft(leftRotate((AVLTreeNode) root.getLeft()));
			//Now the violation is reduced to Left -> Left case. So, we perform right rotation on 'root'
			root = rightRotate(root);
		}
		return root;
	}

	// Get Balance factor of node N
	// We are always calculation (left - right)
	private static int getBalance(AVLTreeNode N) {
		if (N == null)
			return 0;

		return height((AVLTreeNode) N.getLeft())
				- height((AVLTreeNode) N.getRight());
	}

	public static void main(String[] args) {
		AVLTreeNode root = new AVLTreeNode(10);

		/* Constructing tree given in the above figure */
		root = AVLTreeOps.insert(root, 20);
		root = AVLTreeOps.insert(root, 30);
		root = AVLTreeOps.insert(root, 40);
		root = AVLTreeOps.insert(root, 50);
		root = AVLTreeOps.insert(root, 25);
		root = AVLTreeOps.insert(root, 24);
		root = AVLTreeOps.insert(root, 26);

				/* The constructed AVL Tree would be
		        30
		       /  \
		     20   40
		    /  \     \
		   10  25    50
		      /  \
		     24  26		   
		   
		   */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		BinarySearchTreeTraversal.preOrderIterative(root);
		System.out.println("\nInorder traversal: ");
		BinarySearchTreeTraversal.inOrderIterative(root);
		
		root = delete(root, 40);
		
		System.out.println("\nPreorder traversal of constructed tree is after delete: ");
		BinarySearchTreeTraversal.preOrderIterative(root);
		System.out.println("\nInorder traversal after delete: ");
		BinarySearchTreeTraversal.inOrderIterative(root);
	}

}
