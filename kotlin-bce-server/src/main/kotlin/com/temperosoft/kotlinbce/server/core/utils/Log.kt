package com.temperosoft.kotlinbce.server.core.utils

import com.dvsmedeiros.bce.core.controller.INavigationCase
import org.slf4j.LoggerFactory

object Log {
    fun suspendExecutionThenLogError(msg: String?, clazz: Class<*>?, aCase: INavigationCase<*>) {
        val logger = LoggerFactory.getLogger(clazz)
        logger.error(msg)
        aCase.suspendExecution(msg)
    }

    fun suspendExecutionThenLogException(msg: String?, clazz: Class<*>?, aCase: INavigationCase<*>, e: Exception) {
        val logger = LoggerFactory.getLogger(clazz)
        logger.error(e.message, e)
        aCase.suspendExecution(msg)
    }
}