package com.solution.tree;

import com.solution.main.BTreePrinter;
import com.solution.main.ReadInput;
import com.solution.model.Tree;

public class ValidBST {

	public void run() {
		Tree t = ReadInput.getTree("Tree");

		BTreePrinter.printNode(t);

		boolean isValid = doRun(t);

		if (isValid) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}

	private boolean doRun(Tree t) {

		if (t == null) {
			return true;
		}

		// leaf node
		if (t.getLeft() == null && t.getRight() == null) {
			return true;
		}

		int data = (int) t.getData();
		Tree left = t.getLeft();
		Tree right = t.getRight();

		if (null != left && null != right) {
			if (data > (int) left.getData() && data < (int) right.getData()) {
				return doRun(t.getLeft()) && doRun(t.getRight());
			}
		} else if (left != null) {
			if (data > (int) left.getData()) {
				return doRun(left);
			}
		} else if (right != null) {
			if (data < (int) right.getData()) {
				return doRun(right);
			}
		}
		
		return false;
	}
}
