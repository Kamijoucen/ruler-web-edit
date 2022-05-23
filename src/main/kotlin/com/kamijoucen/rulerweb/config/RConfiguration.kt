package com.kamijoucen.rulerweb.config

import com.kamijoucen.ruler.config.RulerConfiguration
import com.kamijoucen.ruler.config.impl.RulerConfigurationImpl
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RConfiguration {

    @Value("\${ruler.maxStackDepth}")
    val maxStackDepth: Int = 100

    @Value("\${ruler.maxLoopNumber}")
    val maxLoopNumber: Int = 10000

    @Bean
    fun rulerConfiguration(): RulerConfiguration {
        val configuration = RulerConfigurationImpl()
        configuration.setGlobalImportModule("/ruler/std/collections.txt", "collections")
        configuration.setGlobalImportModule("/ruler/std/global.txt", "op")
        configuration.setGlobalImportModule("/ruler/std/util.txt", "util")
        configuration.setGlobalImportModule("/ruler/std/sort.txt", "sort")

        configuration.maxLoopNumber = maxLoopNumber
        configuration.maxStackDepth = maxStackDepth
        return configuration
    }

}