package com.solution.tree;

import com.solution.main.BTreePrinter;
import com.solution.main.ReadInput;
import com.solution.model.Tree;

public class LevelOrderTraversal {

	public void run() {
		Tree t = ReadInput.getTree("levelOrderTraversal");

		BTreePrinter.printNode(t);
		
		doPrintLevelOrderTraversal(t);
	}

	private void doPrintLevelOrderTraversal(Tree t) {

		int height = getHeight(t);
		boolean ltr = true;
		for (int i = 1; i <= height; i++) {

			printLevel(t, i, ltr);
			ltr = !ltr;
			System.out.println();
		}

	}

	private void printLevel(Tree t, int i, boolean ltr) {

		if (i == 1) {
			System.out.print(t.getData() + " ");
		} else {
			if (ltr) {
				if (t.getLeft() != null) {
					printLevel(t.getLeft(), i - 1, ltr);

				}
				if (t.getRight() != null) {
					printLevel(t.getRight(), i - 1, ltr);

				}

			} else {
				if (t.getRight() != null) {
					printLevel(t.getRight(), i - 1, ltr);

				}
				if (t.getLeft() != null) {
					printLevel(t.getLeft(), i - 1, ltr);

				}

			}
		}

	}

	private int getHeight(Tree t) {
		if (t == null) {
			return 0;
		}
		int lheight = getHeight(t.getLeft());
		int rheight = getHeight(t.getRight());

		return Math.max(lheight, rheight) + 1;
	}

}
