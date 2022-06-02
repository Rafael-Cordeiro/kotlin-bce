package com.temperosoft.kotlinbce.server.core.business.strategy

import com.temperosoft.kotlinbce.server.core.utils.Log
import com.dvsmedeiros.bce.core.controller.INavigationCase
import com.dvsmedeiros.bce.core.controller.business.IStrategy
import com.temperosoft.kotlinbce.server.domain.model.Employee
import com.temperosoft.kotlinbce.server.domain.persistence.EmployeeRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersistEmployee(
    @Autowired
    val employeeRepository: EmployeeRepository
) : IStrategy<Employee> {

    private val logger: Logger =
        LoggerFactory.getLogger(this::class.java)

    override fun process(entity: Employee, case: INavigationCase<Employee>) {

        try {
            case.result.addEntity(employeeRepository.save(entity))

            logger.info("Funcionário ${entity.name} persistido com sucesso.")
        } catch (e : Exception) {
            Log.suspendExecutionThenLogException("Erro ao persistir funcionário", this::class.java, case, e)
        }

    }

}