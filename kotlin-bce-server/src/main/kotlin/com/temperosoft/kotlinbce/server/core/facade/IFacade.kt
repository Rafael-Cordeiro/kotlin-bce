package com.temperosoft.kotlinbce.server.core.facade

import com.dvsmedeiros.bce.domain.DomainEntity

interface IFacade {

    fun <T : DomainEntity> persistEntity(entity: T, businessCaseName: String) : Any

    fun <T : DomainEntity> fetchEntities(entity: T, businessCaseName: String): List<DomainEntity>

    fun <T : DomainEntity> findEntity(entity : T, businessCaseName: String) : Any

    fun <T : DomainEntity> activateEntity(entity : T, businessCaseName: String) : Any

    fun <T : DomainEntity> inactivateEntity(entity : T, businessCaseName: String) : Any

    fun <T : DomainEntity> deleteEntity(entity : T, businessCaseName: String) : Any

}