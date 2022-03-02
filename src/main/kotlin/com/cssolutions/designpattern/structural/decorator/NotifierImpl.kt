package com.cssolutions.designpattern.structural.decorator

class NotifierImpl: Notifier {
    override fun send(message: String) {
        println("Notifying:$message")
    }
}