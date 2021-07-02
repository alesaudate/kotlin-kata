package com.github.alesaudate.kata

data class InvokePoint(val x: Int, val y: Int )

class MoveAction {
    operator fun invoke(units: Int, direction: String) {
        println("Moving $units to $direction")
    }

    operator fun invoke(point: InvokePoint) {
        println("Moving to point $point")
    }

}


fun main(vararg args: String) {

    val move = MoveAction()
    val targetPoint = InvokePoint(30, 90)

    move(5, "left")
    move(targetPoint)

}