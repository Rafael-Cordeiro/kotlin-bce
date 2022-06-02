package com.temperosoft.kotlinbce.server.domain.model

import com.dvsmedeiros.bce.domain.DomainEntity
import javax.persistence.Entity
import javax.persistence.Table

@Table
@Entity
class Employee (
    var name: String = "",
    var salary: Double = 0.0,
    var position: String = ""
) : DomainEntity()