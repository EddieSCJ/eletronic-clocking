package com.edcleidson.electronicclocking

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class electronicclockingApplication

fun main(args: Array<String>) {
    runApplication<electronicclockingApplication>(*args)
}
