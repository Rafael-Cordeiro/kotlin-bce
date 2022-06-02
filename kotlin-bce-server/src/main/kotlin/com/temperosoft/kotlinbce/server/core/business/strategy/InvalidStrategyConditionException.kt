package com.temperosoft.kotlinbce.server.core.business.strategy

class InvalidStrategyConditionException : RuntimeException {

    companion object {
        @JvmStatic val serialVersionUID = 1L
    }

    constructor() : super()

    constructor(message : String) : super(message)

    constructor(cause: Throwable) : super(cause)

    constructor(message: String, cause: Throwable) : super(message, cause)



}