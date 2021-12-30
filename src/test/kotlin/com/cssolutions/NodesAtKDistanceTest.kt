package com.cssolutions

import com.cssolutions.model.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NodesAtKDistanceTest {

    @Test
    fun distanceNode() {
        val result = DPWorld2().distanceNode(createTree(), TreeNode(11), 1)
        result.map { println(it.key) }
    }

    /**
     *                1
     *              /   \
     *             2     3
     *          /    \
     *         4      5
     *              /   \
     *            10        11
     *          /   \     /   \
     *        20     21 22    23
     */
    private fun createTree() =
        TreeNode(
            key = 1,
            left = TreeNode(
                key = 2,
                left = TreeNode(4),
                right = TreeNode(
                    key = 5,
                    left = TreeNode(10, left = TreeNode(key = 20), right = TreeNode(21)),
                    right = TreeNode
                        (
                        key = 11,
                        left = TreeNode(22),
                        right = TreeNode(23)
                    )
                )
            ),
            right = TreeNode(key = 3)
        )

}