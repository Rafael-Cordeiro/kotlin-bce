package com.temperosoft.kotlinbce.server.domain.persistence

import com.temperosoft.kotlinbce.server.domain.model.Employee

interface EmployeeRepository
//    : JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>
    : ApplicationRepository<Employee>