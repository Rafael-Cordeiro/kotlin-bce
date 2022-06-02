package com.temperosoft.kotlinbce.server.domain.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface ApplicationRepository<T> : JpaRepository<T, Long>, JpaSpecificationExecutor<T>