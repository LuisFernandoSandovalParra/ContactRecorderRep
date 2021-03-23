package structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class AVLTree<T> {
	private Node<T> root;
	private Comparator<T> comparator;

	public AVLTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public void createTree() {
		root = null;
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			return (new Node<T>(data));
		} else if (comparator.compare(data, node.getData()) == -1) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else if (comparator.compare(data, node.getData()) == 1) {
			node.setRightNode(insert(node.getRightNode(), data));
		} else {
			return node;
		}
		node.setHeight(1 + getMax(getHeight(node.getLeftNode()), getHeight(node.getRightNode())));

		if (getBalance(node) > 1 && comparator.compare(data, node.getLeftNode().getData()) == -1) {
			return rightRotate(node);
		} else if (getBalance(node) < -1 && comparator.compare(data, node.getRightNode().getData()) == 1) {
			return leftRotate(node);
		} else if (getBalance(node) > 1 && comparator.compare(data, node.getLeftNode().getData()) == 1) {
			node.setLeftNode(leftRotate(node.getLeftNode()));
			return rightRotate(node);
		} else if (getBalance(node) < -1 && comparator.compare(data, node.getRightNode().getData()) == -1) {
			node.setRightNode(rightRotate(node.getRightNode()));
			return leftRotate(node);
		}
		return node;
	}

	private Node<T> minValueNode(Node<T> node) {
		Node<T> current = node;
		while (current.getLeftNode() != null) {
			current = current.getLeftNode();
		}
		return current;
	}

	public void deleteNode(T data) throws NullPointerException {
		root = deleteNode(root, data);
	}

	private Node<T> deleteNode(Node<T> node, T data) throws NullPointerException {
		Node<T> temp = null;
		if (node == null) {
			throw new NullPointerException();
		} else if (comparator.compare(data, node.getData()) == -1) {
			node.setLeftNode(deleteNode(node.getLeftNode(), data));
		} else if (comparator.compare(data, node.getData()) == 1) {
			node.setRightNode(deleteNode(node.getRightNode(), data));
		} else {
			if ((node.getLeftNode() == null) || (node.getRightNode() == null)) {
				if (temp == node.getLeftNode()) {
					temp = node.getRightNode();
				} else if (temp == node.getRightNode()) {
					temp = node.getLeftNode();
				}
				if (temp == null) {
					temp = node;
					node = null;
				} else {
					node = temp;
				}
			} else {
				temp = minValueNode(node.getRightNode());
				node.setData(temp.getData());
				node.setRightNode(deleteNode(node.getRightNode(), temp.getData()));
			}
		}
		if (node == null) {
			return node;
		}
		node.setHeight(getMax(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1);
		if (getBalance(node) > 1 && getBalance(node.getLeftNode()) >= 0) {
			return rightRotate(node);
		} else if (getBalance(node) > 1 && getBalance(node.getLeftNode()) < 0) {
			node.setLeftNode(leftRotate(node.getLeftNode()));
			return rightRotate(node);
		} else if (getBalance(node) < -1 && getBalance(node.getRightNode()) <= 0) {
			return leftRotate(node);
		} else if (getBalance(node) < -1 && getBalance(node.getRightNode()) > 0) {
			node.setRightNode(rightRotate(node.getRightNode()));
			return leftRotate(node);
		}
		return node;
	}

	private Node<T> rightRotate(Node<T> node) {
		Node<T> leftChildNode = node.getLeftNode();
		Node<T> rightNodeLeftChild = leftChildNode.getRightNode();
		leftChildNode.setRightNode(node);
		node.setLeftNode(rightNodeLeftChild);
		node.setHeight(getMax(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1);
		leftChildNode
				.setHeight(getMax(getHeight(leftChildNode.getLeftNode()), getHeight(leftChildNode.getRightNode())) + 1);
		return leftChildNode;
	}

	private Node<T> leftRotate(Node<T> node) {
		Node<T> rightChildNode = node.getRightNode();
		Node<T> leftNodeRightChild = rightChildNode.getLeftNode();
		rightChildNode.setLeftNode(node);
		node.setRightNode(leftNodeRightChild);
		node.setHeight(getMax(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1);
		rightChildNode.setHeight(
				getMax(getHeight(rightChildNode.getLeftNode()), getHeight(rightChildNode.getRightNode())) + 1);
		return rightChildNode;
	}

	public Node<T> findNode(T data) throws NullPointerException {
		Node<T> auxNode = root;
		while (auxNode != null) {
			if (comparator.compare(data, auxNode.getData()) == 0) {
				return auxNode;
			} else {
				if (comparator.compare(data, auxNode.getData()) == 1) {
					auxNode = auxNode.getRightNode();
				} else {
					auxNode = auxNode.getLeftNode();
				}
			}
		}
		throw new NullPointerException();
	}

	public boolean isIntoTree(T data) {
		Node<T> reco = root;
		while (reco != null) {
			if (comparator.compare(data, reco.getData()) == 0) {
				return true;
			} else {
				if (comparator.compare(data, reco.getData()) == 1) {
					reco = reco.getRightNode();
				} else {
					reco = reco.getLeftNode();
				}
			}
		}
		return false;
	}

	public Iterator<T> inOrder() {
		ArrayList<T> inOrderList = new ArrayList<T>();
		inOrder(inOrderList, root);
		return inOrderList.iterator();
	}

	private void inOrder(ArrayList<T> inOrderList, Node<T> node) {
		if (node != null) {
			inOrder(inOrderList, node.getLeftNode());
			inOrderList.add(node.getData());
			inOrder(inOrderList, node.getRightNode());
		}
	}

	public Iterator<T> preOrder() {
		ArrayList<T> preOrderList = new ArrayList<T>();
		preOrder(preOrderList, root);
		return preOrderList.iterator();
	}

	private void preOrder(ArrayList<T> preOrderList, Node<T> node) {
		if (node != null) {
			preOrderList.add(node.getData());
			preOrder(preOrderList, node.getLeftNode());
			preOrder(preOrderList, node.getRightNode());
		}
	}

	public Iterator<T> postOrder() {
		ArrayList<T> postOrderList = new ArrayList<T>();
		postOrder(postOrderList, root);
		return postOrderList.iterator();
	}

	private void postOrder(ArrayList<T> postOrderList, Node<T> node) {
		if (node != null) {
			postOrder(postOrderList, node.getLeftNode());
			postOrder(postOrderList, node.getRightNode());
			postOrderList.add(node.getData());
		}
	}

	public boolean isEmpty() {
		return root == null ? true : false;
	}

	private int getHeight(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	private int getMax(int valueOne, int valueTwo) {
		return (valueOne > valueTwo) ? valueOne : valueTwo;
	}

	private int getBalance(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
	}
}