package com.cssolutions.algorithm.easy

fun reShapeMatrix(array: Array<IntArray>, row: Int, col: Int) : Array<IntArray>
{
    if(!isLegalReshape(array, row, col))
        return array
    val flattenArray = array.flatMap { it.asIterable() }
    val resultArray = Array(row) { IntArray(col)}

    var k =0
    for(i in 0 until row){
        for (j in 0 until col)
            resultArray[i][j] = flattenArray[k++]
    }
    return resultArray
}

private fun isLegalReshape(array: Array<IntArray>, row: Int, col: Int): Boolean {
    val flatten = array.flatMap { it.asIterable() }
    return row*col == flatten.size
}
