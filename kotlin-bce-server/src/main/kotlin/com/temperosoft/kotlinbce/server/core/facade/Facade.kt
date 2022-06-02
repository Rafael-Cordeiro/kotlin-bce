package com.temperosoft.kotlinbce.server.core.facade

import com.dvsmedeiros.bce.core.controller.impl.BusinessCase
import com.dvsmedeiros.bce.core.controller.impl.BusinessCaseBuilder
import com.dvsmedeiros.bce.core.controller.impl.Navigator
import com.dvsmedeiros.bce.domain.DomainEntity
import com.temperosoft.kotlinbce.server.core.business.strategy.InvalidStrategyConditionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class Facade(
    @Autowired
    var navigator : Navigator<DomainEntity>
) : IFacade {

    private fun <T : DomainEntity> getBusinessCase(businessCaseName: String) :BusinessCase<T> {
        return BusinessCaseBuilder<T>().withName(businessCaseName).build()
    }

    @Transactional
    override fun <T : DomainEntity> persistEntity(entity: T, businessCaseName: String): T {
        val case = getBusinessCase<T>(businessCaseName)
        navigator.run(entity, case)

        if (case.result.message != null)
            throw InvalidStrategyConditionException(case.result.message)
        return case.result.getEntity()
    }

    @Transactional
    override fun <T : DomainEntity> fetchEntities(entity: T, businessCaseName: String): List<T> {
        val case = getBusinessCase<T>(businessCaseName)
        navigator.run(entity, case)

        if (case.result.message != null)
            throw InvalidStrategyConditionException(case.result.message)
        return case.result.getEntity()
    }

    @Transactional
    override fun <T : DomainEntity> findEntity(entity: T, businessCaseName: String): Any {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun <T : DomainEntity> activateEntity(entity: T, businessCaseName: String): Any {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun <T : DomainEntity> inactivateEntity(entity: T, businessCaseName: String): Any {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun <T : DomainEntity> deleteEntity(entity: T, businessCaseName: String): Any {
        TODO("Not yet implemented")
    }

}