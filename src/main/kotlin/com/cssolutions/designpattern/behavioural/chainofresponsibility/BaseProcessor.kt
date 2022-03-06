package com.cssolutions.designpattern.behavioural.chainofresponsibility

abstract class BaseProcessor(private val processor: Processor?): Processor {

    override fun process(request: NumberRequest) {
        processor?.process(request)
    }
}