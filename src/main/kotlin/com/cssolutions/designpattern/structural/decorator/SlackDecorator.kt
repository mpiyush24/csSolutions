package com.cssolutions.designpattern.structural.decorator

class SlackDecorator(private val notifier: Notifier): BaseDecorator(notifier) {
    override fun send(message: String) {
        notifier.send("Notifying Slack: $message")
    }
}