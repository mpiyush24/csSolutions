package com.cssolutions.designpattern.structural.decorator


/**
 * “Wrapper” is the alternative nickname for the Decorator pattern that clearly expresses the main idea of the pattern.
 * A wrapper is an object that can be linked with some target object.
 * The wrapper contains the same set of methods as the target and delegates to it all requests it receives. However,
 * the wrapper may alter the result by doing something either before or after it passes the request to the target.
 */
class Driver(private val slackEnabled: Boolean, private val facebookEnabled: Boolean) {

    fun driverFunction() {
        val notifier = getNotifiers(slackEnabled, facebookEnabled)
        notifier.send("This is a test message")
    }

    private fun getNotifiers(slackEnabled: Boolean, facebookEnabled: Boolean): Notifier {

        var notifier: Notifier = NotifierImpl()

        if(slackEnabled) {
            notifier = SlackDecorator(notifier)
        }

        if(facebookEnabled) {
            notifier = FaceBookDecorator(notifier)
        }
        return notifier
    }
}

fun main() {
    Driver(slackEnabled = true, facebookEnabled = true).driverFunction()
    println("#############")
    Driver(slackEnabled = true, facebookEnabled = false).driverFunction()
    println("#############")
    Driver(slackEnabled = false, facebookEnabled = true).driverFunction()
}