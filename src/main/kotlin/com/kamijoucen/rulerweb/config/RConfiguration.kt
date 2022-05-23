package com.kamijoucen.rulerweb.config

import com.kamijoucen.ruler.config.RulerConfiguration
import com.kamijoucen.ruler.config.impl.RulerConfigurationImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RConfiguration {

    @Bean
    fun rulerConfiguration(): RulerConfiguration {
        val configuration = RulerConfigurationImpl()
        configuration.setGlobalImportModule("/ruler/std/collections.txt", "collections")
        configuration.setGlobalImportModule("/ruler/std/global.txt", "op")
        configuration.setGlobalImportModule("/ruler/std/util.txt", "util")
        configuration.setGlobalImportModule("/ruler/std/sort.txt", "sort")

        configuration.maxLoopNumber = 100000;
        configuration.maxStackDepth = 2000
        return configuration
    }

}