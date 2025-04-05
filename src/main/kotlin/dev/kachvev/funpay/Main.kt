package dev.kachvev.funpay

import dev.kachvev.extention.file.local
import dev.kachvev.extention.profile.Profiler

fun main() {
    val profiler = Profiler("File")
    profiler.start()


    val config = local("config.yml")
    println("config: ${config.readText()}")

    println(profiler.stop())
}