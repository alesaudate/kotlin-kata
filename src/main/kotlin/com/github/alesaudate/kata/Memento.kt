package com.github.alesaudate.kata

data class Originator(var text: String) {

    fun saveToMemento() = Memento(text)

    fun restore(memento: Memento) {
        text = memento.originalText
    }
}

data class Memento(val originalText: String)

interface UndoCommand<T> {
    operator fun invoke(): T
}

class UndoTypingCommand(private val memento: Memento) : UndoCommand<String> {
    override operator fun invoke() = memento.originalText
}

fun main(vararg args: String) {
    val originator = Originator("123")
    val memento = originator.saveToMemento()

    originator.text = "456"
    val undo = UndoTypingCommand(memento)

    val result = undo()
    println(result)
}


