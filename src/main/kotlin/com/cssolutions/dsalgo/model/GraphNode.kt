package com.cssolutions.dsalgo.model

data class GraphNode(
    val `val`: Int,
    var neighbors: ArrayList<GraphNode?> = arrayListOf()
)
