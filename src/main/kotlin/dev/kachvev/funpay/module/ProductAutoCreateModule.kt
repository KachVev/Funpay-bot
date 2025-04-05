package dev.kachvev.funpay.module

import dev.kachvev.extention.file.local
import dev.kachvev.funpay.module.api.ApplicationModule

class ProductAutoCreateModule : ApplicationModule {
    override val name: String = "ProductAutoCreate"

    override fun start() {
        val config = local("config.yml")
        println("config.yml: ${config.readText()}")
    }
}