package com.temperosoft.kotlinbce.server.rest

import com.temperosoft.kotlinbce.server.core.business.strategy.InvalidStrategyConditionException
import com.temperosoft.kotlinbce.server.core.facade.Facade
import com.temperosoft.kotlinbce.server.domain.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employee")
class EmployeeController(
    @Autowired
    private val facade: Facade
) {

    @GetMapping
    fun findAll() : ResponseEntity<Any> {
        return try {
            ResponseEntity.status(HttpStatus.OK).body(facade.fetchEntities(Employee(),"FETCH_EMPLOYEES",))
        } catch (e : InvalidStrategyConditionException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
        }
    }

    @PostMapping
    fun post(@RequestBody employee : Employee) : ResponseEntity<Any> {
        return try {
            ResponseEntity.status(HttpStatus.CREATED).body(facade.persistEntity(employee, "PERSIST_EMPLOYEE"))
        } catch (e : InvalidStrategyConditionException) {
            ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.message)
        }
    }

}