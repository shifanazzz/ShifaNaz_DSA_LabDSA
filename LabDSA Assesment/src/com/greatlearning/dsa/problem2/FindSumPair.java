package com.greatlearning.dsa.problem2;

import java.util.HashSet;

public class FindSumPair {
	static class Node {
		int nodeData;
		Node leftNode, rightNode;

	};

	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}

	public Node insert(Node root, int data) {
		if (root == null)
			return newNode(data);
		if (data < root.nodeData) {
			root.leftNode = insert(root.leftNode, data);
		} else {
			root.rightNode = insert(root.rightNode, data);
		}
		return root;
	}

	public static boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.leftNode, sum, set))
			return true;
		if (set.contains(sum - root.nodeData)) {
			System.out.println("Pair found is (" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else
			set.add(root.nodeData);
		return findPairUtil(root.rightNode, sum, set);

	}

	public static void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		if (findPairUtil(root, sum, set))
			System.out.println("Pairs exist");
		// else if(!findPairUtil(root, sum, set));
		else
			System.out.println("Pairs do not exist");
	}

	public static void main(String[] args) {
		Node root = null;
		FindSumPair obj = new FindSumPair();
		root = obj.insert(root, 40);
		root = obj.insert(root, 20);
		root = obj.insert(root, 60);
		root = obj.insert(root, 10);
		root = obj.insert(root, 30);
		root = obj.insert(root, 50);
		root = obj.insert(root, 70);
		int sum = 50;
		System.out.println("Sum = " + sum);
		FindSumPair.findPairWithGivenSum(root, sum);

	}

}
