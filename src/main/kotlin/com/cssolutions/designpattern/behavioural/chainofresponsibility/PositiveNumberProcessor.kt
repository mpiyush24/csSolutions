package com.cssolutions.designpattern.behavioural.chainofresponsibility

class PositiveNumberProcessor(private val processor: Processor) : BaseProcessor(processor) {
    override fun process(request: NumberRequest) {
        if (request.number > 0) {
            println("processing via PositiveNumberProcessor")
        } else {
            processor.process(request)
        }
    }
}