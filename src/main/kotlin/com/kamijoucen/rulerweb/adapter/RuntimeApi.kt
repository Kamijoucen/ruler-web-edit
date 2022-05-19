package com.kamijoucen.rulerweb.adapter

import com.kamijoucen.ruler.Ruler
import com.kamijoucen.ruler.common.Tuple2
import com.kamijoucen.ruler.config.RulerConfiguration
import com.kamijoucen.ruler.parameter.RuleResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/runtime")
class RuntimeApi(val configuration: RulerConfiguration) {

    @PostMapping("/run")
    fun run(@RequestBody script: String): Tuple2<Long, RuleResult> {
        val runner = Ruler.compileScript(script, configuration)
        return timing { runner.run() }
    }
}

fun timing(run: () -> RuleResult): Tuple2<Long, RuleResult> {
    val t1 = System.currentTimeMillis()
    val result = run.invoke()
    val t2 = System.currentTimeMillis()
    val time = t2 - t1
    return Tuple2(time, result)
}