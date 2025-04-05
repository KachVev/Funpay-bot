package dev.kachvev.funpay

import com.charleskorn.kaml.Yaml
import dev.kachvev.extention.file.local
import dev.kachvev.extention.profile.Profiler
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString

fun main() {
    val profiler = Profiler("File")
    profiler.start()

    val configFile = local("config.yml")
    println("config.yml = $configFile")

    val profiler2 = Profiler("ConfigRead")
    profiler2.start()

    val config = Yaml.default.decodeFromString<Config>(configFile.readText())

    println("""
        config.yml = ${config.readText}
    """.trimIndent())

    println(profiler.stop())
    println(profiler2.stop())
}

@Serializable
data class Config(val readText: String)