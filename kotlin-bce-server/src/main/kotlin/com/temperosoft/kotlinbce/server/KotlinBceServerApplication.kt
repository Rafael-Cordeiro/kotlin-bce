package com.temperosoft.kotlinbce.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.temperosoft.kotlinbce","com.dvsmedeiros.bce"])
@EnableJpaRepositories("com.temperosoft.kotlinbce.server.domain.persistence")
@EntityScan
class KotlinBceServerApplication {

	companion object {
		@JvmStatic fun main(args: Array<String>) {
			runApplication<KotlinBceServerApplication>(*args)
		}
	}

}
