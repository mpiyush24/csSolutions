import com.cssolutions.dsalgo.model.TreeNode

/*
Create a Unbalanced Binary Search Tree with given Values.

Given 2 Nodes find the distance between 2 nodes.
 */

fun distanceBetweenNodes(node1: Int, node2 : Int, values : List<Int>): Int {

    var bstTree = createBstTree(values)

    return  1
}

private fun createBstTree(values: List<Int>): TreeNode {

    val tree = TreeNode()

    for (i in values.indices) {
        insertIntoBST(tree, values[i])
    }
    return  tree;
}

private fun insertIntoBST(tree: TreeNode, value: Int) {

    if(tree.key == -1 ) {
        tree.key = value
        return
    }

    if(value < tree.key) {
        if(tree.left == null) {
            val leftNode = TreeNode()
            leftNode.key = value
            tree.left = leftNode
            return
        } else insertIntoBST(tree.left!!, value)

    } else {
        if(tree.right == null) {
            val rightNode = TreeNode()
            rightNode.key = value
            tree.right = rightNode
            return
        } else insertIntoBST(tree.right!!, value)

    }

}






