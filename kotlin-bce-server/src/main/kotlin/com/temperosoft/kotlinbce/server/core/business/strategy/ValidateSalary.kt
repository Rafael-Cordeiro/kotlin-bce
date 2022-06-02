package com.temperosoft.kotlinbce.server.core.business.strategy

import com.dvsmedeiros.bce.core.controller.INavigationCase
import com.dvsmedeiros.bce.core.controller.business.IStrategy
import com.temperosoft.kotlinbce.server.core.utils.Log
import com.temperosoft.kotlinbce.server.domain.model.Employee
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component

@Component
@Slf4j
class ValidateSalary : IStrategy<Employee> {

    override fun process(entity: Employee, case: INavigationCase<Employee>) {

        try {
            if (entity.salary < 1000.0)
                case.suspendExecution("Salário do funcionário menor que o salário mínimo.")
        } catch (e : Exception) {
            Log.suspendExecutionThenLogException("Erro ao validar o salário do funcionário ${entity.name}", this::class.java, case, e)
        }

    }


}