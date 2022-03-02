package com.cssolutions.designpattern.structural.decorator

class FaceBookDecorator(private val notifier: Notifier) : BaseDecorator(notifier) {
    override fun send(message: String) {
        notifier.send(message)
        println("Notifying facebook:$message")
    }
}