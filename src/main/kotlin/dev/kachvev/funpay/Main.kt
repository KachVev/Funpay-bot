package dev.kachvev.funpay

import dev.kachvev.extention.profile.Profiler
import dev.kachvev.funpay.module.ProductAutoCreateModule
import dev.kachvev.funpay.module.api.ApplicationModule

fun main() {
    val moduleLoading = Profiler("ModuleLoading")
    moduleLoading.start()

    val modules = listOf<ApplicationModule>(
        ProductAutoCreateModule()
    )

    modules.forEach { module ->
        val moduleStart = Profiler("Start module with name ${module.name}")
        moduleStart.start()
        module.start()
        println("Module '${module.name}' took ${moduleStart.stop()} seconds")
    }

    println("Done!")
    println("Total module loading time: ${moduleLoading.stop()} seconds")
}
