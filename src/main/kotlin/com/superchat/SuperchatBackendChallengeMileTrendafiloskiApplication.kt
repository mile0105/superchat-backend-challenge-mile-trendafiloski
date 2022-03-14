package com.superchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.superchat"])
@EntityScan("com.superchat.*")
class SuperchatBackendChallengeMileTrendafiloskiApplication

fun main(args: Array<String>) {
    runApplication<SuperchatBackendChallengeMileTrendafiloskiApplication>(*args)
}
