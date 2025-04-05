package dev.kachvev.extention.profile

import java.util.*

class Profiler(val profilerName: String) {
    var totalTime = 0L
        private set
    var startTime = 0L
        private set
    var isRunning = false
        private set

    fun start(): Profiler = apply {
        require(!isRunning) { "$profilerName is already running." }
        startTime = System.nanoTime()
        isRunning = true
    }

    fun stop(): Double {
        require(isRunning) { "$profilerName is not running." }
        val elapsedTime = System.nanoTime() - startTime + totalTime
        isRunning = false
        totalTime = elapsedTime

        return (elapsedTime / 1_000_000_000.0).let {
            String.format(Locale.US, "%.3f", it).toDouble()  // Используем три знака после запятой
        }
    }

    companion object {
        val activeProfiles = mutableMapOf<String, Profiler>()

        fun start(graphName: String): Profiler = Profiler(graphName).apply {
            activeProfiles[graphName] = this
            start()
        }

        fun getProfileResult(graphName: String): Double? = activeProfiles[graphName]?.stop()
    }
}