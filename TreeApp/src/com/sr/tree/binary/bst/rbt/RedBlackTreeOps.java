/**
 * 
 */
package com.sr.tree.binary.bst.rbt;

import com.sr.tree.binary.BinarySearchTreeTraversal;


/**
 * @author sayanroy
 *
 */
public class RedBlackTreeOps {
	
	private static final boolean BLACK = true;
	
	private static final boolean RED = false;
	
	/**
	 * This method is only for BST insertion as RedBlack Tree.
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private static RedBlackTreeNode bstInsert(RedBlackTreeNode root, RedBlackTreeNode node) {
		//performing BST insertion operation
		if (root == null) {
			return node;
		}
		if (node.getData() < root.getData()) {
			root.setLeft(bstInsert((RedBlackTreeNode) root.getLeft(), node));
			RedBlackTreeNode left = (RedBlackTreeNode) root.getLeft();
			left.setParent(root);
			
		} else if (node.getData() > root.getData()) {
			root.setRight(bstInsert((RedBlackTreeNode) root.getRight(), node));
			RedBlackTreeNode right = (RedBlackTreeNode) root.getRight();
			right.setParent(root);
		} 
		return root;
		//==== INSERTION logic end above =======
	}
	
	private static RedBlackTreeNode leftRotate(RedBlackTreeNode root, RedBlackTreeNode node) {
		if (node != null) {
            RedBlackTreeNode right = (RedBlackTreeNode) node.getRight();
            RedBlackTreeNode rightLeft = (RedBlackTreeNode) right.getLeft();
            RedBlackTreeNode nodeParent = node.getParent();
            
            //setting up left of right of node
            node.setRight(rightLeft);
            if (rightLeft != null)
            	rightLeft.setParent(node);
            //setting 'right' parent to node's parent
            right.setParent(nodeParent);
            //fixing root the new root if 'node' was existing root
            if (nodeParent == null)
                root = right;
            //setting node new child
            else if ((RedBlackTreeNode) nodeParent.getLeft() == node)
            	nodeParent.setLeft(right);
            else
            	nodeParent.setRight(right);
            //setting node to it's right's left
            right.setLeft(node);
            //setting right as node's parent
            node.setParent(right);
        }
		return root;
	}
	
	private static RedBlackTreeNode rightRotate(RedBlackTreeNode root, RedBlackTreeNode node) {
		if (node != null) {
            RedBlackTreeNode left = (RedBlackTreeNode) node.getLeft();
            RedBlackTreeNode leftRight = (RedBlackTreeNode) left.getRight();
            RedBlackTreeNode nodeParent = node.getParent();
            node.setLeft(left.getRight());
            if (leftRight != null) 
            	leftRight.setParent(node);
            left.setParent(nodeParent);
            if (nodeParent == null)
                root = left;
            else if ((RedBlackTreeNode) nodeParent.getRight() == node)
            	nodeParent.setRight(left);
            else 
            	nodeParent.setLeft(left);
            left.setRight(node);
            node.setParent(left);
        }
		return root;
	}
	
	private static RedBlackTreeNode fixViolation(RedBlackTreeNode root,
			RedBlackTreeNode node) {
		RedBlackTreeNode parent = null, grandParent = null;
		while (node != root && node.getColor() == RED
				&& node.getParent().getColor() == RED) {
			parent = node.getParent();
			grandParent = parent.getParent();
			

			// CASE - A : Uncle color is RED. In this case only recoloring
			// is required. No rotation will be performed for this iteration
			RedBlackTreeNode uncle = getUncle(parent);
			if (uncle != null && uncle.getColor() == RED) {
				// performing recoloring
				// change parent and uncle to BLACK
				parent.setColor(BLACK);
				uncle.setColor(BLACK);
				// change grandparent color to RED
				grandParent.setColor(RED);
				// setting node to it's grand parent for next iteration
				node = grandParent;
			} else {
				// CASE - B : Uncle color is BLACK. In this case we need to
				// appropriate rotation followed by recoloring. Diving this case
				// to below 2 primary subcases.

				// SUBCASE - 1 : if the parent is left child of grandParent
				if (parent == (RedBlackTreeNode) grandParent.getLeft()) {
					// For this sub-case we have below 2 different conditions.
					// CONDITION - a : If the 'node' is left child of it's
					// parent.
					// In this case Right -> Right rotation is required (RR).
					if (node == (RedBlackTreeNode) parent.getLeft()) {
						// perform RR rotation on grandparent
						root = rightRotate(root, grandParent);
						// swap color
						swapColor(grandParent, parent);
					} else if (node == (RedBlackTreeNode) parent.getRight()) {
						// CONDITION - b : If the 'node' is right child of it's
						// parent.
						// In this case Left -> Right rotation is required (LR).

						// 1st left rotate 'parent' and change 'node' to point
						// to it. As,
						// after rotation parent will become child and child
						// will become parent
						root = leftRotate(root, parent);
						node = parent;
						parent = node.getParent();

						// Now this condition is reduced to CONDITION - a. So,
						// perform Right rotation
						// on grandparent.
						root = rightRotate(root, grandParent);
						// swap color
						swapColor(grandParent, parent);
					}
					node = parent;
				}
				// SUBCASE - 2 : if the parent is right child of grandParent
				else if (parent == (RedBlackTreeNode) grandParent.getRight()) {
					// For this sub-case we have below 2 different conditions.
					// CONDITION - a : If the 'node' is right child of it's
					// parent.
					// In this case Left -> Left rotation is required (LL).
					if (node == (RedBlackTreeNode) parent.getRight()) {
						// perform LL rotation on grandparent
						root = leftRotate(root, grandParent);
						// swap color
						swapColor(grandParent, parent);
					} else if (node == (RedBlackTreeNode) parent.getLeft()) {
						// CONDITION - b : If the 'node' is left child of it's
						// parent.
						// In this case Right -> Left rotation is required (RL).

						// 1st right rotate 'parent' and change 'node' to point
						// to it. As,
						// after rotation parent will become child and child
						// will become parent
						root = rightRotate(root, parent);
						node = parent;
						parent = node.getParent();

						// Now this condition is reduced to CONDITION - a. So,
						// perform Left rotation
						// on grandparent.
						root = leftRotate(root, grandParent);
						// swap color
						swapColor(grandParent, parent);
					}
					node = parent;
				}
			}
		}
		// finally setting the root color 'BLACK' to retain RedBlack tree
		// property.
		root.setColor(BLACK);
		return root;
	}
	
	private static void swapColor(RedBlackTreeNode n1, RedBlackTreeNode n2) {
		if (n1 != null && n2 != null) {
			boolean n1Color = n1.getColor();
			n1.setColor(n2.getColor());
			n2.setColor(n1Color);
		}
	}
	
	private static RedBlackTreeNode getUncle(RedBlackTreeNode parent) {
		RedBlackTreeNode grandParent = null;
		if (parent == null || (grandParent = parent.getParent()) == null) {
			return null;
		}
		if (parent == (RedBlackTreeNode) grandParent.getLeft()) {
			return (RedBlackTreeNode) grandParent.getRight();
		} else if (parent == (RedBlackTreeNode) grandParent.getRight()) {
			return (RedBlackTreeNode) grandParent.getLeft();
		}
		return null;
	}
	
	public static RedBlackTreeNode insert(RedBlackTreeNode root, int data) {
		RedBlackTreeNode node = new RedBlackTreeNode(data, RED);
		root = bstInsert(root, node);
		return fixViolation(root, node);
	}
	
	public static void main(String[] args) {
		RedBlackTreeNode root = new RedBlackTreeNode(7, BLACK);
		 
	    root = RedBlackTreeOps.insert(root, 6);
	    root = RedBlackTreeOps.insert(root, 5);
	    root = RedBlackTreeOps.insert(root, 4);
	    root = RedBlackTreeOps.insert(root, 3);
	    //root = RedBlackTreeOps.insert(root, 2);
	    //root = RedBlackTreeOps.insert(root, 1);
	 
	    System.out.println("Preorder traversal" + " of constructed tree is : ");
		BinarySearchTreeTraversal.preOrderIterative(root);
		System.out.println("\nInorder traversal: ");
		BinarySearchTreeTraversal.inOrderIterative(root);
	}

}
