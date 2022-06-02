package com.temperosoft.kotlinbce.server.core.business.navigation

import com.dvsmedeiros.bce.core.controller.impl.Navigation
import com.dvsmedeiros.bce.core.controller.impl.NavigationBuilder
import com.temperosoft.kotlinbce.server.core.business.strategy.FetchEmployees
import com.temperosoft.kotlinbce.server.core.business.strategy.PersistEmployee
import com.temperosoft.kotlinbce.server.core.business.strategy.ValidateSalary
import com.temperosoft.kotlinbce.server.domain.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EmployeeNavigation(
    @Autowired
    val validateSalary: ValidateSalary,

    @Autowired
    val persistEmployee: PersistEmployee,

    @Autowired
    val fetchEmployees: FetchEmployees

) {

    @Bean(name = ["PERSIST_EMPLOYEE"])
    fun persistEmployee() : Navigation<Employee> {
        return NavigationBuilder<Employee>()
            .next(validateSalary)
            .next(persistEmployee)
            .build()
    }

    @Bean(name = ["FETCH_EMPLOYEES"])
    fun fetchEmployees() : Navigation<Employee> {
        return NavigationBuilder<Employee>()
            .next(fetchEmployees)
            .build()
    }

}