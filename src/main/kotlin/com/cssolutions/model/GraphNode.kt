package com.cssolutions.model

data class GraphNode(
    val `val`: Int,
    var neighbors: ArrayList<GraphNode?> = arrayListOf()
)
