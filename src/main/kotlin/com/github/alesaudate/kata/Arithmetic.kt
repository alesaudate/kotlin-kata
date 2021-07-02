package com.github.alesaudate.kata

import java.lang.Math.pow
import kotlin.math.sqrt

data class Point(private val x: Double, private val y: Double) {

    companion object {
        val ORIGIN = Point(0.0, 0.0)
    }

    operator fun minus(other: Point): Double {
        return sqrt(pow(x - other.x, 2.0) + pow(y - other.y, 2.0))
    }


    operator fun compareTo(other: Point): Int {
        val distanceToOrigin = this - ORIGIN
        val otherDistanceToOrigin = other - ORIGIN
        return when {
            distanceToOrigin > otherDistanceToOrigin -> 1
            distanceToOrigin == otherDistanceToOrigin -> 0
            else -> -1
        }
    }
}


fun main() {
    val spaceStationPosition = Point(100.0, 100.0)
    val spaceShuttlePosition = Point(10.0, 10.0)

    val distance = spaceStationPosition - spaceShuttlePosition

    println("Distance between space station and its shuttle is $distance cartesian points")

    when (spaceStationPosition > spaceShuttlePosition) {
        true -> println("The space station is further than the shuttle")
        false -> println("The shuttle is further")
    }


}