package dev.kachvev.funpay

import dev.kachvev.extention.profile.Profiler
import dev.kachvev.funpay.module.ProductAutoCreateModule
import dev.kachvev.funpay.module.api.ApplicationModule
import org.slf4j.LoggerFactory

fun main() {
    val logger = LoggerFactory.getLogger("ProfilerLogger")

    val moduleLoading = Profiler("ModuleLoading")
    moduleLoading.start()

    val modules = listOf<ApplicationModule>(
        ProductAutoCreateModule()
    )

    modules.forEach { module ->
        val moduleStart = Profiler("StartModule")
        moduleStart.start()
        module.start()

        logger.info("Module '${module.name}' took ${moduleStart.stop()} seconds")
    }

    logger.info("Total module loading time: ${moduleLoading.stop()} seconds")
}
