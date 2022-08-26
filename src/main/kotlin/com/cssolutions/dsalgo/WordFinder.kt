package com.cssolutions.dsalgo

/*
The conflict with your students escalates, and now they are hiding multiple words in a single word grid. Return the location of each word as a list of coordinates. Letters cannot be reused across words.

grid1 = [
    ['b', 'a', 'b'],
    ['y', 't', 'a'],
    ['x', 'x', 't'],
]

words1_1 = ["by","bat"]

find_word_locations(grid1, words1_1) =>
([(0, 0), (1, 0)],
 [(0, 2), (1, 2), (2, 2)])

grid2 =[
    ['A', 'B', 'A', 'B'],
    ['B', 'A', 'B', 'A'],
    ['A', 'B', 'Y', 'B'],
    ['B', 'Y', 'A', 'A'],
    ['A', 'B', 'B', 'A'],
]
words2_1 = ['ABABY', 'ABY', 'AAA', 'ABAB', 'BABB']

([(0, 0), (1, 0), (2, 0), (2, 1), (3, 1)],
 [(1, 1), (1, 2), (2, 2)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

or

([(0, 0), (1, 0), (1, 1), (1, 2), (2, 2)],
 [(2, 0), (2, 1), (3, 1)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

or

([(0, 0), (0, 1), (1, 1), (1, 2), (2, 2)],
 [(2, 0), (2, 1), (3, 1)],
 [(3, 2), (3, 3), (4, 3)],
 [(0, 2), (0, 3), (1, 3), (2, 3)],
 [(3, 0), (4, 0), (4, 1), (4, 2)])

words2_2 = ['ABABA', 'ABA', 'BAB', 'BABA', 'ABYB']

([(0, 0), (1, 0), (2, 0), (3, 0), (4, 0)],
 [(3, 2), (4, 2), (4, 3)],
 [(0, 1), (0, 2), (1, 2)],
 [(0, 3), (1, 3), (2, 3), (3, 3)],
 [(1, 1), (2, 1), (3, 1), (4, 1)])

or

([(0, 0), (1, 0), (2, 0), (3, 0), (4, 0)],
 [(3, 2), (4, 2), (4, 3)],
 [(0, 1), (0, 2), (0, 3)],
 [(1, 2), (1, 3), (2, 3), (3, 3)],
 [(1, 1), (2, 1), (3, 1), (4, 1)])


Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/
fun main(args: Array<String>) {
// val words = arrayOf( "cat", "baby", "dog", "bird", "car", "ax" );
// val string1 = "tcabnihjs";
// val string2 = "tbcanihjs";
// val string3 = "baykkjl";
// val string4 = "bbabylkkj";
// val string5 = "ccc";
// val string6 = "breadmaking";

// println(Solution().solve(words, string1))
// println(Solution().solve(words, string2))
// println(Solution().solve(words, string3))
// println(Solution().solve(words, string4))
// println(Solution().solve(words, string5))
// println(Solution().solve(words, string6))

// val grid1 = arrayOf(
// 	arrayOf("c", "c", "x", "t", "i", "b"), //0
// 	arrayOf("c", "c", "a", "t", "n", "i"), //1
// 	arrayOf("a", "c", "n", "n", "t", "t"), // 2
// 	arrayOf("t", "c", "s", "i", "p", "t"),// 3
// 	arrayOf("a", "o", "o", "o", "a", "a"),// 4
// 	arrayOf("o", "a", "a", "a", "o", "o"),// 5
// 	arrayOf("k", "a", "i", "c", "k", "i"));//6

// val word1 = "catnip";
// val word2 = "cccc";
// val word3 = "s";
// val word4 = "bit";
// val word5 = "aoi";
// val word6 = "ki";
// val word7 = "aaa";
// val word8 = "ooo";

// val grid2 = arrayOf(arrayOf("a"));
// val word9 = "a";

// println(Solution2().solve(grid1, word1))
// println(Solution2().solve(grid1, word2))
// println(Solution2().solve(grid1, word3))
// println(Solution2().solve(grid1, word4))
// println(Solution2().solve(grid1, word5))
// println(Solution2().solve(grid1, word6))
// println(Solution2().solve(grid1, word7))
// println(Solution2().solve(grid1, word8))
// println(Solution2().solve(grid2, word9))

    val grid1 = arrayOf(
        arrayOf("b", "a", "b"),
        arrayOf("y", "t", "a"),
        arrayOf("x", "x", "t")
    );
    val words1_1 = arrayOf("by", "bat");

    val grid2 = arrayOf(
        arrayOf("A", "B", "A", "B"),
        arrayOf("B", "A", "B", "A"),
        arrayOf("A", "B", "Y", "B"),
        arrayOf("B", "Y", "A", "A"),
        arrayOf("A", "B", "B", "A")
    );
    val words2_1 = arrayOf("ABABY", "ABY", "AAA", "ABAB", "BABB");
    val words2_2 = arrayOf("ABABA", "ABA", "BAB", "BABA", "ABYB");

    Solution3().solve(grid1, words1_1)
    Solution3().solve(grid2, words2_1)
    Solution3().solve(grid2, words2_2)

}


class Solution3 {
    fun solve(grid: Array<Array<String>>, inputList: Array<String>): List<Pair<Int, Int>>? {
        val eligibleWordsList = mutableListOf<List<List<Pair<Int, Int>>>>()
        for (input in inputList) {
            val eligibleWordList = mutableSetOf<List<Pair<Int, Int>>>()
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    val result = mutableListOf<Pair<Int, Int>>()
                    dfs(grid, i, j, result, 0, input, eligibleWordList)
                }
            }
            eligibleWordsList.add(eligibleWordList.toList())
        }

        val result = getNonCollidingSolution(eligibleWordsList)
        println(result)
        return null
    }

    private fun getNonCollidingSolution(eligibleWordsList: MutableList<List<List<Pair<Int, Int>>>>): List<List<Pair<Int, Int>>>? {
        val cartesian = mutableListOf<List<List<Pair<Int, Int>>>>()
        generateCartesianProduct(eligibleWordsList, cartesian, mutableListOf(), 0)
        return cartesian.firstOrNull { product -> isNonColliding(product) }

    }

    private fun isNonColliding(product: List<List<Pair<Int, Int>>>): Boolean {
        val map = mutableMapOf<Pair<Int, Int>, Int>()
        for (pairList in product) {
            for (pair in pairList) {
                if (map.computeIfPresent(pair) { _, v -> v + 1 } == null) {
                    map[pair] = 1
                }
            }
        }
        return map.values.firstOrNull { it > 1 } == null
    }


    fun dfs(
        grid: Array<Array<String>>,
        i: Int,
        j: Int,
        result: MutableList<Pair<Int, Int>>,
        charPos: Int,
        word: String,
        eligibleWordList: MutableSet<List<Pair<Int, Int>>>
    ) {
        if (result.size == word.length) {
            eligibleWordList.add(result.toList())
            return
        }
        if (i >= grid.size || j >= grid[0].size || charPos >= word.length || grid[i][j].toCharArray()[0] != word.get(
                charPos
            )) {
            return
        }

        val pair = Pair(i, j)
        result.add(pair)
        dfs(grid, i + 1, j, result, charPos + 1, word, eligibleWordList)
        dfs(grid, i, j + 1, result, charPos + 1, word, eligibleWordList)
        result.remove(pair)
    }

    fun generateCartesianProduct(
        eligibleWordsList: List<List<List<Pair<Int, Int>>>>,
        result: MutableList<List<List<Pair<Int, Int>>>>,
        interimProduct: MutableList<List<Pair<Int, Int>>>,
        k: Int
    ) {

        if (k == eligibleWordsList.size) {
            result.add(interimProduct.toList())
            return
        }

        for (i in 0 until eligibleWordsList.get(k).size) {
            interimProduct.add(eligibleWordsList.get(k).get(i))
            generateCartesianProduct(eligibleWordsList, result, interimProduct, k + 1)
            interimProduct.remove(eligibleWordsList.get(k).get(i))
        }

    }
}
//
//class Solution2 {
//    fun solve(grid: Array<Array<String>>, input: String): List<Pair<Int, Int>>? {
//        for (i in grid.indices) {
//            for (j in grid[0].indices) {
//                val result = mutableListOf<Pair<Int, Int>>()
//                dfs(grid, i, j, result, 0, input)
//                if (result.size == input.length) {
//                    return result
//                }
//            }
//        }
//        return null
//    }
//
//    fun dfs(
//        grid: Array<Array<String>>,
//        i: Int,
//        j: Int,
//        result: MutableList<Pair<Int, Int>>,
//        charPos: Int,
//        word: String
//    ) {
//        if (result.size == word.length) {
//            return
//        }
//        if (i >= grid.size || j >= grid[0].size || charPos >= word.length || grid[i][j].toCharArray()[0] != word.get(
//                charPos
//            )
//        ) {
//            return
//        }
//        val pair = Pair(i, j)
//        result.add(pair)
//        dfs(grid, i + 1, j, result, charPos + 1, word)
//        dfs(grid, i, j + 1, result, charPos + 1, word)
//        if (result.size != word.length) {
//            result.remove(pair)
//        }
//    }
//}
//
//class Solution {
//    fun solve(dict: Array<String>, input: String): String? {
//        val inputFreqMap = createFreqMap(input)
//
//        for (word in dict) {
//            val wordFreqMap = createFreqMap(word)
//            var wordFound = true
//            for (ch in word) {
//                if (inputFreqMap[ch] ?: 0 < wordFreqMap[ch]!!) {
//                    wordFound = false
//                    break;
//                }
//            }
//            if (wordFound) {
//                return word
//            }
//        }
//        return null
//    }
//
//    fun createFreqMap(input: String): Map<Char, Int> {
//        val map = mutableMapOf<Char, Int>()
//        for (ch in input.toCharArray()) {
//            if (map.computeIfPresent(ch, { _, v -> v + 1 }) == null) {
//                map[ch] = 1
//            }
//        }
//        return map.toMap()
//    }
//}
