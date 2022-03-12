package com.cssolutions.dsalgo.array

/**

There is a car with capacity empty seats. The vehicle only drives east
(i.e., it cannot turn around and drive west).

You are given the integer capacity and an array
trips where trips[i] = [numPassengersi, fromi, toi] indicates
that the ith trip has numPassengersi passengers and the locations
to pick them up and drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers
for all the given trips, or false otherwise.
 */
class CarPooling {
    // time: o(n2) space: o(n)
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val auxArray = IntArray(1001) { 0 }
        for (trip in trips) {
            auxArray[trip[1]] += trip[0]
            auxArray[trip[2]] -= trip[0]
        }
        for (i in 1 until auxArray.size) {
            auxArray[i] += auxArray[i - 1]
            if (auxArray[i] > capacity) {
                return false
            }
        }
        return true;
    }
}