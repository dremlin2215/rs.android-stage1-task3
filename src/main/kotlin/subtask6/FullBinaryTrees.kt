package subtask6

import java.util.*

/*
### 6) Full Binary Trees
A full binary tree is a binary tree where each node has exactly 0 or 2 children.
Return a list of all possible full binary trees with N nodes.
Each node of each tree in the answer must have its value set to 0.
You may return the final list of trees in any order.

Example:
Input: 7
Output:
[
[0,0,0,null,null,0,0,null,null,0,0],
[0,0,0,null,null,0,0,0,0],
[0,0,0,0,0,0,0],
[0,0,0,0,0,null,null,null,null,0,0],
[0,0,0,0,0,null,null,0,0]
]

For a visual explanation on the output have a look at the following example:
<img alt="example trees" src="/images/ExampleTrees.png" />
The order of images vs output lines is from left to right, from top to bottom.
Note: trailing null nodes are omitted from the output.
*/
class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        val binaryTreeCombinations = createAllBinaryTreeCombination(count)
        val res = mutableListOf<MutableList<Int?>>()
        for (node in binaryTreeCombinations) {
            val stateOfNode = createStatesOfNode(node!!)
            while (stateOfNode[stateOfNode.size - 1] == null) {
                stateOfNode.removeAt(stateOfNode.size - 1)
            }
            res.add(stateOfNode)
        }
        return res.toString()
    }

    private fun createAllBinaryTreeCombination(count: Int): ArrayList<TreeNode?> {
        if (count == 1) return arrayListOf(TreeNode(0))
        if (count % 2 == 0) return ArrayList()
        val list = ArrayList<TreeNode?>()
        for (i in 0 until count) {
            for (left in createAllBinaryTreeCombination(i)) {
                for (right in createAllBinaryTreeCombination(count - i - 1)) {
                    val node = TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }

    private fun createStatesOfNode(node: TreeNode): ArrayList<Int?> {
        var level = 0
        val resultArray = arrayListOf<Int?>(0)
        val nodeChildren = arrayListOf(node.left, node.right)
        while (nodeChildren.isNotEmpty()) {
            val grandChildren = arrayListOf<TreeNode?>();
            for (child in nodeChildren) {
                if (child == null && level != node.value) {
                    resultArray.add(null);
                } else if (child != null) {
                    resultArray.add(0);
                    grandChildren.add(child.left);
                    grandChildren.add(child.right);
                }
            }
            level++;
            nodeChildren.clear();
            nodeChildren.addAll(grandChildren);
            grandChildren.clear();
        }
        return resultArray;
    }

    class TreeNode {
        var value: Int = 0
        var left: TreeNode? = null
        var right: TreeNode? = null

        constructor() {}
        constructor(value: Int) {
            this.value = value
        }

        constructor(value: Int, left: TreeNode, right: TreeNode) {
            this.value = value
            this.left = left
            this.right = right
        }

        fun hasChildren(): Boolean {
            if (left == null && right == null) {
                return false
            }
            return true
        }
    }
}
