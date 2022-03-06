package com.cssolutions.designpattern.behavioural.chainofresponsibility

interface Processor {
    fun process(request: NumberRequest)
}