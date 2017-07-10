package com.solution.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.solution.main.BTreePrinter;
import com.solution.main.ReadInput;
import com.solution.model.Tree;

public class TopView {

	int lindex = 0;
	int rindex = 0;

	public void run() {

		Tree t = ReadInput.getTree("TopView");

		Map<Integer, List<Tree>> map = new HashMap<Integer, List<Tree>>();

		BTreePrinter.printNode(t);

		System.out.println("Without Hashing");
		topViewWithoutHashing(t);
		doTopView(t);

	}

	class QItem {
		public QItem(Tree t, int index) {
			this.t = t;
			this.index = index;
		}

		public Tree t;
		public int index;
	}

	private void doTopView(Tree tree) {

		ArrayDeque<QItem> q = new ArrayDeque<>();
		Map<Integer, Tree> map = new HashMap<Integer, Tree>();

		q.add(new QItem(tree, 0));

		while (!q.isEmpty()) {

			QItem qitem = q.poll();
			Tree t = qitem.t;
			if (!map.containsKey(qitem.index)) {
				map.put(qitem.index, qitem.t);
			}

			if (t.getLeft() != null) {
				q.add(new QItem(t.getLeft(), qitem.index - 1));
			}
			if (t.getRight() != null) {
				q.add(new QItem(t.getRight(), qitem.index + 1));
			}
		}

		System.out.println("Hashing:");
		map.forEach((k, v) -> {
			System.out.print(v.getData() + " ");
		});
	}

	private void topViewWithoutHashing(Tree t) {
		int height = getHeight(t);

		for (int i = 0; i < height; i++) {
			doprintTopView(t, 0, i);
		}

	}

	private void doprintTopView(Tree t, int index, int level) {

		if (t == null) {
			return;
		}

		if (level == 0) {
			if (index <= lindex) {
				lindex = index;
				System.out.print(t.getData() + " ");
			} else if (index >= rindex) {
				rindex = index;
				System.out.print(t.getData() + " ");
			}
		} else {
			doprintTopView(t.getLeft(), index - 1, level - 1);
			doprintTopView(t.getRight(), index + 1, level - 1);
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
