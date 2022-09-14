package com.cssolutions.dsalgo.graph

/*
LC-207
 */
class CourseSchedule {

    fun canComplete(numCourses: Int, prerequisites: Array<IntArray> ): Boolean {
        val courseMap = mutableMapOf<Int, MutableList<Int>>()
            for( idx in 0 until numCourses) {
            courseMap[idx] = mutableListOf()
        }
        for(coursePair in prerequisites) {
            courseMap[coursePair[0]]!!.add(coursePair[1])
        }
        for(entry in courseMap) {
            if(!dfs(entry.key, courseMap, mutableSetOf())) return false
        }
        return true
    }

    private fun dfs(course: Int, courseMap: MutableMap<Int, MutableList<Int>>, visited: MutableSet<Int>):  Boolean {
        if(visited.contains(course)) return false
        if(courseMap[course]!!.size == 0) return true
        visited.add(course)
        for(prerequisite in courseMap[course]!!) {
            if(!dfs(prerequisite, courseMap, visited)) return false
        }
        visited.remove(course)
        courseMap[course]!!.clear()
        return true
    }

}
