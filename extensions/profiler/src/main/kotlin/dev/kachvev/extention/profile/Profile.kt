package dev.kachvev.extention.profile

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

    fun stop(): String {
        require(isRunning) { "$profilerName is not running." }
        return "$profilerName took ${System.nanoTime() - startTime + totalTime}.ms".also {
            isRunning = false
            totalTime = System.nanoTime() - startTime + totalTime
        }
    }

    companion object {
        val activeProfiles = mutableMapOf<String, Profiler>()

        fun start(graphName: String): Profiler = Profiler(graphName).apply {
            activeProfiles[graphName] = this
            start()
        }

        fun getProfileResult(graphName: String): String? = activeProfiles[graphName]?.stop()
    }
}
