package com.cssolutions.dsalgo.graph

class MaximumGold {
    fun getMaximumGold(grid: Array<IntArray>): Int {

        var maxGCollected = 0
        val vA = Array(grid.size) {BooleanArray(grid[0].size){false}}
        for(i in grid.indices) {
            for( j in grid[0].indices) {
                if(grid[i][j] != 0){
                    println("${grid[i][j]}")
                    val result = MaxGoldCollected()
                    dogetMaximumGold(grid,
                        vA.copy(),
                        i,
                        j,
                        result,
                        0
                    )

                    if(maxGCollected < result.value) {
                        maxGCollected = result.value
                    }
                }



            }
        }
        return maxGCollected;

    }

    fun dogetMaximumGold(grid: Array<IntArray>, vA: Array<BooleanArray>, i: Int, j: Int, result: MaxGoldCollected, goldCollected: Int) {
        if(i < 0 || j < 0 || i >= grid.size || j >=grid[0].size || vA[i][j] || grid[i][j] == 0) {

            println("return i--$i j--$j}")
            return
        }

        vA[i][j] = true

        result.value = result.value.coerceAtLeast(goldCollected + grid[i][j])

        println("$goldCollected ${grid[i][j]}")

        dogetMaximumGold(grid, vA, i, j+1, result, goldCollected + grid[i][j])
        dogetMaximumGold(grid, vA, i, j-1, result, goldCollected + grid[i][j])
        dogetMaximumGold(grid, vA, i+1, j, result, goldCollected + grid[i][j])
        dogetMaximumGold(grid, vA, i-1, j, result, goldCollected + grid[i][j])

        vA[i][j] = false


    }

    fun Array<BooleanArray>.copy() = this.map {it.clone()}.toTypedArray()
}


data class MaxGoldCollected(
    var value: Int = 0
)


